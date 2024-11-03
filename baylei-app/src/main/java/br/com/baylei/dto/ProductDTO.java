package br.com.baylei.dto;

import br.com.baylei.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String id;
    @NotBlank(message = "Nome deve ser informado")
    private String name;
    @NotBlank(message = "Descrição deve ser informada")
    private String description;
    @NotNull(message = "Preço deve ser informado")
    private BigDecimal price;
    @NotNull(message = "Quantidade deve ser informada")
    private Integer quantity;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public static Product of(ProductDTO productDTO) {

        var product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setId(productDTO.getId());
        product.setQuantity(productDTO.getQuantity());

        return product;
    }

    public static ProductDTO of(Product product) {
    return ProductDTO.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .quantity(product.getQuantity())
        .dateCreated(product.getDateCreated())
        .dateUpdated(product.getDateUpdated())
        .build();
    }

    public static List<ProductDTO> ofProducts(List<Product> products) {
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }
}
