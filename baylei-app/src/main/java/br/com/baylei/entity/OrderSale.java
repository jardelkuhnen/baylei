package br.com.baylei.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document
public class OrderSale extends BaseEntity {

    private String clientId;
    private String sellerId;
    private List<Product> products;
    private BigDecimal discount;
    private BigDecimal totalOrder;
    private BigDecimal totalOrderWithDiscount;


}
