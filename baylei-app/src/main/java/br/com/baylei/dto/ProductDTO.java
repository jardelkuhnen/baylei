package br.com.baylei.dto;

import br.com.baylei.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public static Product of(ProductDTO productDTO) {

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setId(productDTO.getId());

        return product;
    }

    public static ProductDTO of(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .dateCreated(product.getDateCreated())
                .dateUpdated(product.getDateUpdated())
                .build();
    }
}
