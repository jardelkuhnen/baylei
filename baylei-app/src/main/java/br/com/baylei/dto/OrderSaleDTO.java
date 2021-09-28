package br.com.baylei.dto;

import br.com.baylei.entity.OrderSale;
import br.com.baylei.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderSaleDTO {

    private String id;
    private ClientDTO client;
    private SellerDTO seller;
    private List<ProductDTO> products;
    private BigDecimal discount;
    private BigDecimal totalOrder;
    private BigDecimal totalOrderWithDiscount;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public static OrderSaleDTO of(OrderSale orderSale, List<Product> products, ClientDTO clientDTO, SellerDTO sellerDTO) {
        return OrderSaleDTO.builder()
                .id(orderSale.getId())
                .client(clientDTO)
                .seller(sellerDTO)
                .discount(orderSale.getDiscount())
                .totalOrder(orderSale.getTotalOrder())
                .totalOrderWithDiscount(orderSale.getTotalOrderWithDiscount())
                .products(ProductDTO.ofProducts(products))
                .dateCreated(orderSale.getDateCreated())
                .dateUpdated(orderSale.getDateUpdated())
                .build();
    }

    public static OrderSale of(OrderSaleDTO orderSaleDTO) {
        var orderSale = new OrderSale();

        orderSale.setId(orderSaleDTO.getId());
        orderSale.setClientId(orderSaleDTO.getId());
        orderSale.setSellerId(orderSaleDTO.getId());
        orderSale.setDiscount(orderSaleDTO.getDiscount());

        return orderSale;
    }

}
