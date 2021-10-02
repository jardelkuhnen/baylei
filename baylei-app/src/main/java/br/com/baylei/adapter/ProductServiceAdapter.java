package br.com.baylei.adapter;

import br.com.baylei.api.ProductService;
import br.com.baylei.dto.ProductDTO;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.model.Product;
import br.com.baylei.usecase.ProductPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductServiceAdapter implements ProductService {

    private final ProductPersistencePort productPersistencePort;

    @Autowired
    public ProductServiceAdapter(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    public ProductDTO save(ProductDTO productDTO) {

        var product = ProductDTO.of(productDTO);
        product.setDateCreated(LocalDateTime.now());

        return ProductDTO.of(productPersistencePort.save(product));
    }

    public ProductDTO update(ProductDTO productDTO) {
        Product product = this.productPersistencePort.getById(productDTO.getId());

        if (Objects.isNull(product)) {
            throw new NotFoundException("Não localizado Produto com id -> " + productDTO.getId());
        }

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setDateUpdated(LocalDateTime.now());

        return ProductDTO.of(productPersistencePort.save(product));
    }

    public List<ProductDTO> getAll() {
        List<Product> productEntities = productPersistencePort.getAll();

        List<ProductDTO> productDTOS = productEntities.stream().map(ProductDTO::of).collect(Collectors.toList());

        return productDTOS;
    }

    public ProductDTO getById(String id) {
        Product product = productPersistencePort.getById(id);

        if (Objects.isNull(product)) {
            throw new NotFoundException("Não localizado produto para id -> " + id);
        }

        return ProductDTO.of(product);
    }

    public void deleteById(String id) {
        this.productPersistencePort.deleteById(id);
    }

    @Override
    public List<ProductDTO> findByIds(List<String> productsIds) {
        List<Product> productsFound = new ArrayList<>();

        productPersistencePort.getAllById(productsIds).forEach(productsFound::add);

        return productsFound.stream().map(ProductDTO::of).collect(Collectors.toList());
    }
}
