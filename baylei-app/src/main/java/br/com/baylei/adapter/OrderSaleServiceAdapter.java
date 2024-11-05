package br.com.baylei.adapter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.baylei.api.OrderSaleService;
import br.com.baylei.dto.OrderSaleDTO;
import br.com.baylei.dto.ProductDTO;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.model.OrderSale;
import br.com.baylei.model.Product;
import br.com.baylei.usecase.ClientPersistencePort;
import br.com.baylei.usecase.OrderSalePersistencePort;
import br.com.baylei.usecase.ProductPersistencePort;
import br.com.baylei.usecase.SellerPersistencePort;

public class OrderSaleServiceAdapter implements OrderSaleService {

    private final OrderSalePersistencePort orderSalePersistencePort;
    private final SellerPersistencePort sellerPersistencePort;
    private final ClientPersistencePort clientPersistencePort;
    private final ProductPersistencePort productPersistencePort;

    public OrderSaleServiceAdapter(OrderSalePersistencePort orderSalePersistencePort,
                                   SellerPersistencePort sellerPersistencePort,
                                   ClientPersistencePort clientPersistencePort,
                                   ProductPersistencePort productPersistencePort) {
        this.orderSalePersistencePort = orderSalePersistencePort;
        this.sellerPersistencePort = sellerPersistencePort;
        this.clientPersistencePort = clientPersistencePort;
        this.productPersistencePort = productPersistencePort;
    }

    public static BigDecimal getTotalOrderPrice(List<ProductDTO> products) {
        var totalOrder = new BigDecimal(0);
        for (ProductDTO product : products) {
            totalOrder = totalOrder.add(product.getPrice());
        }

        return totalOrder;
    }

    private BigDecimal sumTotalProducts(List<Product> productEntities) {
        BigDecimal totalProducts = BigDecimal.ZERO;
        List<BigDecimal> priceProducts = productEntities.stream().map(p -> p.getPrice()).collect(Collectors.toList());

        totalProducts = priceProducts.stream().reduce(totalProducts, BigDecimal::add);

        return totalProducts;
    }

    @Override
    public OrderSaleDTO save(OrderSaleDTO orderSaleDTO) {
        List<String> produtcsId = orderSaleDTO.getProducts().stream().map(p -> p.getId()).collect(Collectors.toList());

        List<Product> productEntities = productPersistencePort.getAllById(produtcsId);

        if (productEntities.isEmpty()) {
            throw new NotFoundException("Não localizados os produtos!");
        }

        var client = clientPersistencePort.getById(orderSaleDTO.getClient().getId());
        if (Objects.isNull(client)) {
            throw new NotFoundException("Não localizado cliente!");
        }

        var seller = sellerPersistencePort.getById(orderSaleDTO.getSeller().getId());
        if (Objects.isNull(seller)) {
            throw new NotFoundException("Não localizado o vendedor!");
        }

        var orderSale = OrderSaleDTO.of(orderSaleDTO);
        orderSale.setClientId(client.getId());
        orderSale.setSellerId(seller.getId());

        BigDecimal totalProducts = sumTotalProducts(productEntities);

        orderSale.setProductIds(produtcsId);
        orderSale.setTotalOrder(totalProducts);
        orderSale.setDateCreated(LocalDateTime.now());
        orderSale.setTotalOrderWithDiscount(totalProducts.subtract(orderSaleDTO.getDiscount()));

        return OrderSaleDTO.of(orderSalePersistencePort.save(orderSale), productEntities, client, seller);
    }

    @Override
    public OrderSaleDTO update(OrderSaleDTO orderSaleDTO) {
        var orderSale = orderSalePersistencePort.getById(orderSaleDTO.getId());

        if (Objects.isNull(orderSale)) {
            throw new NotFoundException("Não localizado ordem de venda pra id -> " + orderSaleDTO.getId());
        }

        orderSale.setDateUpdated(LocalDateTime.now());
        orderSale.setClientId(orderSale.getClientId());
        orderSale.setSellerId(orderSale.getSellerId());


        var client = clientPersistencePort.getById(orderSaleDTO.getClient().getId());
        if (Objects.isNull(client)) {
            throw new NotFoundException("Não localizado cliente!");
        }

        var seller = sellerPersistencePort.getById(orderSaleDTO.getSeller().getId());
        if (Objects.isNull(seller)) {
            throw new NotFoundException("Não localizado o vendedor!");
        }

        List<String> productsId = orderSaleDTO.getProducts().stream().map(p -> p.getId()).collect(Collectors.toList());
        List<Product> productEntities = productPersistencePort.getAllById(productsId);

        orderSale.setProductIds(productsId);

        BigDecimal totalOrder = getTotalOrderPrice(orderSaleDTO.getProducts());

        orderSale.setTotalOrder(totalOrder);
        orderSale.setTotalOrderWithDiscount(totalOrder.subtract(orderSaleDTO.getDiscount()));

        return OrderSaleDTO.of(orderSalePersistencePort.save(orderSale), productEntities, client, seller);
    }

    @Override
    public List<OrderSaleDTO> getAll() {
        List<OrderSale> ordersSale = orderSalePersistencePort.getAll();

        List<OrderSaleDTO> dtos = new ArrayList<>();

        for (OrderSale orderSaleEntity : ordersSale) {
            List<Product> productEntities = productPersistencePort.getAllById(orderSaleEntity.getProductIds());
            var sellerDTO = sellerPersistencePort.getById(orderSaleEntity.getSellerId());
            var clientDTO = clientPersistencePort.getById(orderSaleEntity.getClientId());

            dtos.add(OrderSaleDTO.of(orderSaleEntity, productEntities, clientDTO, sellerDTO));
        }

        return dtos;
    }

    @Override
    public OrderSaleDTO getById(String id) {
        var orderSale = orderSalePersistencePort.getById(id);

        if (Objects.isNull(orderSale)) {
            throw new NotFoundException("Não localizado ordem de venda pra id -> " + id);
        }


        List<Product> productEntities = productPersistencePort.getAllById(orderSale.getProductIds());
        var sellerDTO = sellerPersistencePort.getById(orderSale.getSellerId());
        var clientDTO = clientPersistencePort.getById(orderSale.getClientId());

        return OrderSaleDTO.of(orderSale, productEntities, clientDTO, sellerDTO);
    }

    @Override
    public void deleteById(String id) {
        orderSalePersistencePort.deleteById(id);
    }
}
