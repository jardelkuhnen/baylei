package br.com.baylei.service;

import br.com.baylei.dto.ClientDTO;
import br.com.baylei.dto.OrderSaleDTO;
import br.com.baylei.dto.ProductDTO;
import br.com.baylei.dto.SellerDTO;
import br.com.baylei.entity.OrderSale;
import br.com.baylei.entity.Product;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.repository.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderSaleService {

    private final OrderSaleRepository orderSaleRepository;
    private final ProductService productService;
    private final ClientService clientService;
    private final SellerService sellerService;

    @Autowired
    public OrderSaleService(OrderSaleRepository orderSaleRepository,
                            ProductService productService, ClientService clientService, SellerService sellerService) {
        this.orderSaleRepository = orderSaleRepository;
        this.productService = productService;
        this.clientService = clientService;
        this.sellerService = sellerService;
    }

    public static BigDecimal getTotalOrderPrice(List<ProductDTO> products) {
        var totalOrder = new BigDecimal(0);
        for (ProductDTO dto : products) {
            totalOrder = totalOrder.add(dto.getPrice());
        }

        return totalOrder;
    }

    public OrderSaleDTO save(OrderSaleDTO orderSaleDTO) {

        List<String> produtcsId = orderSaleDTO.getProducts().stream().map(p -> p.getId()).collect(Collectors.toList());
        List<Product> products = productService.findByIds(produtcsId);

        if (products.isEmpty()) {
            throw new NotFoundException("Não localizados os produtos!");
        }

        ClientDTO clientDTO = clientService.getById(orderSaleDTO.getClient().getId());
        if (Objects.isNull(clientDTO)) {
            throw new NotFoundException("Não localizado cliente!");
        }

        SellerDTO sellerDTO = sellerService.getById(orderSaleDTO.getSeller().getId());
        if (Objects.isNull(sellerDTO)) {
            throw new NotFoundException("Não localizado o vendedor!");
        }

        var orderSale = OrderSaleDTO.of(orderSaleDTO);

        BigDecimal totalProducts = sumTotalProducts(products);

        orderSale.setProductIds(produtcsId);
        orderSale.setTotalOrder(totalProducts);
        orderSale.setTotalOrderWithDiscount(totalProducts.subtract(orderSaleDTO.getDiscount()));
        orderSale.setDateCreated(LocalDateTime.now());

        return OrderSaleDTO.of(orderSaleRepository.save(orderSale), products, clientDTO, sellerDTO);
    }

    private BigDecimal sumTotalProducts(List<Product> products) {
        BigDecimal totalProducts = BigDecimal.ZERO;
        List<BigDecimal> priceProducts = products.stream().map(p -> p.getPrice()).collect(Collectors.toList());

        totalProducts = priceProducts.stream().reduce(totalProducts, BigDecimal::add);

        return totalProducts;
    }

    public OrderSaleDTO update(OrderSaleDTO orderSaleDTO) {

        var orderSaleOptional = orderSaleRepository.findById(orderSaleDTO.getId());

        if (orderSaleOptional.isEmpty()) {
            throw new NotFoundException("Não localizado ordem de venda pra id -> " + orderSaleDTO.getId());
        }

        var orderSale = orderSaleOptional.get();
        orderSale.setDateUpdated(LocalDateTime.now());
        orderSale.setClientId(orderSale.getClientId());
        orderSale.setSellerId(orderSale.getSellerId());


        ClientDTO clientDTO = clientService.getById(orderSaleDTO.getClient().getId());
        if (Objects.isNull(clientDTO)) {
            throw new NotFoundException("Não localizado cliente!");
        }

        SellerDTO sellerDTO = sellerService.getById(orderSaleDTO.getSeller().getId());
        if (Objects.isNull(sellerDTO)) {
            throw new NotFoundException("Não localizado o vendedor!");
        }

        List<String> productsId = orderSaleDTO.getProducts().stream().map(p -> p.getId()).collect(Collectors.toList());
        List<Product> products = productService.findByIds(productsId);

        orderSale.setProductIds(productsId);

        BigDecimal totalOrder = getTotalOrderPrice(orderSaleDTO.getProducts());

        orderSale.setTotalOrder(totalOrder);
        orderSale.setTotalOrderWithDiscount(totalOrder.subtract(orderSaleDTO.getDiscount()));

        return OrderSaleDTO.of(orderSaleRepository.save(orderSale), products, clientDTO, sellerDTO);
    }

    public List<OrderSaleDTO> getAll() {
        List<OrderSale> ordersSale = orderSaleRepository.findAll();

        List<OrderSaleDTO> dtos = new ArrayList<>();

        for (OrderSale orderSale : ordersSale) {
            List<Product> products = productService.findByIds(orderSale.getProductIds());
            var sellerDTO = sellerService.getById(orderSale.getSellerId());
            var clientDTO = clientService.getById(orderSale.getClientId());

            dtos.add(OrderSaleDTO.of(orderSale, products, clientDTO, sellerDTO));
        }

        return dtos;
    }

    public OrderSaleDTO getById(String id) {

        var orderSaleOptional = orderSaleRepository.findById(id);

        if (orderSaleOptional.isEmpty()) {
            throw new NotFoundException("Não localizado ordem de venda pra id -> " + id);
        }

        var orderSale = orderSaleOptional.get();

        List<Product> products = productService.findByIds(orderSale.getProductIds());
        var sellerDTO = sellerService.getById(orderSale.getSellerId());
        var clientDTO = clientService.getById(orderSale.getClientId());

        return OrderSaleDTO.of(orderSale, products, clientDTO, sellerDTO);
    }

    public void deleteById(String id) {
        this.orderSaleRepository.deleteById(id);
    }

}
