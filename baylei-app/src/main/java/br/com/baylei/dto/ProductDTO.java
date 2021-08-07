package br.com.baylei.dto;

import br.com.baylei.entity.Product;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ProductDTO {

    private String id;
    @NotBlank(message = "Nome deve ser informado")
    private String name;
    @NotBlank(message = "Descrição deve ser informada")
    private String description;
    @NotBlank(message = "Preço deve ser informado")
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

    public static List<Product> ofProductsDTO(List<ProductDTO> products) {
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }

    public static List<ProductDTO> ofProducts(List<Product> products) {
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }
}
