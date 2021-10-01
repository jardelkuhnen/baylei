package br.com.baylei.adapter;


import br.com.baylei.entity.ProductEntity;
import br.com.baylei.model.Product;
import br.com.baylei.ports.ProductPersistencePort;
import br.com.baylei.repository.ProductRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductSpringJpaAdapter implements ProductPersistencePort {

    private final ProductRepository productRepository;

    public ProductSpringJpaAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        var productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        BeanUtils.copyProperties(productRepository.save(productEntity), product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();

        for (ProductEntity entity : productEntities) {
            var seller = new Product();
            BeanUtils.copyProperties(entity, seller);
            products.add(seller);
        }

        return products;
    }

    @Override
    public Product getById(String id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);

        if (!productEntityOptional.isPresent()) {
            return null;
        }

        var product = new Product();

        BeanUtils.copyProperties(productEntityOptional.get(), product);
        return product;
    }

    @Override
    public Product update(Product product) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(product.getId());

        if (!optionalProductEntity.isPresent()) {
            return null;
        }

        var productEntity = optionalProductEntity.get();
        BeanUtils.copyProperties(product, productEntity);
        BeanUtils.copyProperties(productRepository.save(productEntity), product);

        return product;
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllById(List<String> productsId) {
        List<Product> products = new ArrayList<>();
        productRepository.findAllById(productsId).forEach(entity -> {
            var product = new Product();
            BeanUtils.copyProperties(entity, product);
            products.add(product);
        });

        return products;
    }
}
