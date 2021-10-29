package br.com.baylei.dto;

import br.com.baylei.model.Client;
import br.com.baylei.model.OrderSale;
import br.com.baylei.model.Product;
import br.com.baylei.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSaleDTO {

    private String id;
    @NotNull(message = "Client não informado!")
    private ClientDTO client;
    @NotNull(message = "Vendedor não informado!")
    private SellerDTO seller;
    @NotEmpty(message = "Produtos não informados!")
    private List<ProductDTO> products;
    private BigDecimal discount;
    private BigDecimal totalOrder;
    private BigDecimal totalOrderWithDiscount;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public static OrderSaleDTO of(OrderSale orderSale, List<Product> products, Client client, Seller seller) {
        return OrderSaleDTO.builder()
                .id(orderSale.getId())
                .client(ClientDTO.of(client))
                .seller(SellerDTO.of(seller))
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
