package br.com.baylei.dto;

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
    private List<String> productsId;
    private BigDecimal totalOrder;
    private BigDecimal discount;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


}
