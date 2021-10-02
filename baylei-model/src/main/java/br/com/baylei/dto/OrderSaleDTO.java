package br.com.baylei.dto;

import br.com.baylei.model.Client;
import br.com.baylei.model.OrderSale;
import br.com.baylei.model.Product;
import br.com.baylei.model.Seller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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


    public static OrderSaleDTO of(OrderSale orderSale, List<Product> productEntities, Client client, Seller seller) {
        var dto = new OrderSaleDTO();
        dto.setId(orderSale.getId());
        dto.setClient(ClientDTO.of(client));
        dto.setSeller(SellerDTO.of(seller));
        dto.setDiscount(orderSale.getDiscount());
        dto.setTotalOrder(orderSale.getTotalOrder());
        dto.setTotalOrderWithDiscount(orderSale.getTotalOrderWithDiscount());
        dto.setProducts(ProductDTO.ofProducts(productEntities));
        dto.setDateCreated(orderSale.getDateCreated());
        dto.setDateUpdated(orderSale.getDateUpdated());

        return dto;
    }

    public static OrderSale of(OrderSaleDTO orderSaleDTO) {
        var orderSale = new OrderSale();

        orderSale.setId(orderSaleDTO.getId());
        orderSale.setClientId(orderSaleDTO.getClient().getId());
        orderSale.setSellerId(orderSaleDTO.getSeller().getId());
        orderSale.setDiscount(orderSaleDTO.getDiscount());

        return orderSale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerDTO seller) {
        this.seller = seller;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
