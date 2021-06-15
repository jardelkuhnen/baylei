package br.com.baylei.service;

import br.com.baylei.dto.OrderSaleDTO;
import br.com.baylei.dto.ProductDTO;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.repository.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderSaleService {

    private final OrderSaleRepository orderSaleRepository;

    @Autowired
    public OrderSaleService(OrderSaleRepository orderSaleRepository) {
        this.orderSaleRepository = orderSaleRepository;
    }

    public static BigDecimal getTotalOrderPrice(List<ProductDTO> products) {
        var totalOrder = new BigDecimal(0);
        for (ProductDTO dto : products) {
            totalOrder = totalOrder.add(dto.getPrice());
        }

        return totalOrder;
    }

    public OrderSaleDTO save(OrderSaleDTO orderSaleDTO) {

        var orderSale = OrderSaleDTO.of(orderSaleDTO);
        orderSale.setDateCreated(LocalDateTime.now());

        return OrderSaleDTO.of(orderSaleRepository.save(orderSale));
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
        orderSale.setProducts(ProductDTO.ofProductsDTO(orderSaleDTO.getProducts()));

        BigDecimal totalOrder = getTotalOrderPrice(orderSaleDTO.getProducts());

        orderSale.setTotalOrder(totalOrder);
        orderSale.setTotalOrderWithDiscount(totalOrder.subtract(orderSaleDTO.getDiscount()));

        return OrderSaleDTO.of(orderSaleRepository.save(orderSale));
    }

    public List<OrderSaleDTO> getAll() {
        return orderSaleRepository.findAll().stream().map(OrderSaleDTO::of).collect(Collectors.toList());
    }

    public OrderSaleDTO getById(String id) {

        var orderSaleOptional = orderSaleRepository.findById(id);

        if (orderSaleOptional.isEmpty()) {
            throw new NotFoundException("Não localizado ordem de venda pra id -> " + id);
        }

        return OrderSaleDTO.of(orderSaleOptional.get());
    }

    public void deleteById(String id) {
        this.orderSaleRepository.deleteById(id);
    }

}
