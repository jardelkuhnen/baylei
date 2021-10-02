package br.com.baylei.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document
public class OrderSaleEntity extends BaseEntity {

    private String clientId;
    private String sellerId;
    private List<String> productIds;
    private BigDecimal discount;
    private BigDecimal totalOrder;
    private BigDecimal totalOrderWithDiscount;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(BigDecimal totalOrder) {
        this.totalOrder = totalOrder;
    }

    public BigDecimal getTotalOrderWithDiscount() {
        return totalOrderWithDiscount;
    }

    public void setTotalOrderWithDiscount(BigDecimal totalOrderWithDiscount) {
        this.totalOrderWithDiscount = totalOrderWithDiscount;
    }
}
