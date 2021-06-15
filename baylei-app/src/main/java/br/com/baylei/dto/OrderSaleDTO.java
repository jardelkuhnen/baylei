package br.com.baylei.dto;

import br.com.baylei.entity.OrderSale;
import br.com.baylei.service.OrderSaleService;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderSaleDTO {

    private String id;
    private String clientId;
    private String sellerId;
    private List<ProductDTO> products;
    private BigDecimal discount;
    private BigDecimal totalOrder;
    private BigDecimal totalOrderWithDiscount;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;



    public static OrderSaleDTO of(OrderSale orderSale) {
        return OrderSaleDTO.builder()
                .id(orderSale.getId())
                .clientId(orderSale.getClientId())
                .sellerId(orderSale.getSellerId())
                .discount(orderSale.getDiscount())
                .totalOrder(orderSale.getTotalOrder())
                .totalOrderWithDiscount(orderSale.getTotalOrderWithDiscount())
                .products(ProductDTO.ofProducts(orderSale.getProducts()))
                .build();
    }

    public static OrderSale of(OrderSaleDTO orderSaleDTO) {
        var orderSale = new OrderSale();

        orderSale.setId(orderSaleDTO.getId());
        orderSale.setClientId(orderSaleDTO.getClientId());
        orderSale.setSellerId(orderSaleDTO.getSellerId());
        orderSale.setDiscount(orderSaleDTO.getDiscount());
        orderSale.setProducts(ProductDTO.ofProductsDTO(orderSaleDTO.getProducts()));

        BigDecimal totalOrder = OrderSaleService.getTotalOrderPrice(orderSaleDTO.getProducts());
        orderSale.setTotalOrder(totalOrder);
        orderSale.setTotalOrderWithDiscount(totalOrder.subtract(orderSaleDTO.getDiscount()));

        return orderSale;
    }


}
