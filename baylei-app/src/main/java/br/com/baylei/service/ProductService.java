package br.com.baylei.service;

import br.com.baylei.dto.ProductDTO;
import br.com.baylei.entity.Product;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO save(ProductDTO productDTO) {

        var product = ProductDTO.of(productDTO);
        product.setDateCreated(LocalDateTime.now());

        return ProductDTO.of(productRepository.save(product));
    }

    public ProductDTO update(ProductDTO productDTO) {
        var productOptional = this.productRepository.findById(productDTO.getId());

        if(productOptional.isEmpty()) {
            throw new NotFoundException("Não localizado Produto com id -> " + productDTO.getId());
        }

        var product = productOptional.get();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setDateUpdated(LocalDateTime.now());

        return ProductDTO.of(productRepository.save(product));
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::of).collect(Collectors.toList());

        return productDTOS;
    }

    public ProductDTO getById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()) {
            throw new NotFoundException("Não localizado produto para id -> " + id);
        }

        return ProductDTO.of(productOptional.get());
    }

    public void deleteById(String id) {
        this.productRepository.deleteById(id);
    }

    public List<Product> findByIds(List<String> productsIds) {
        List<Product> productsFound = new ArrayList<>();

        productRepository.findAllById(productsIds).forEach(productsFound::add);

        return productsFound;
    }
}
