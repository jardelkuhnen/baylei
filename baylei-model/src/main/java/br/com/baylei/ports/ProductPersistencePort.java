package br.com.baylei.ports;

import br.com.baylei.model.Client;
import br.com.baylei.model.Product;

import java.util.List;

public interface ProductPersistencePort {

    Product save(Product product);

    List<Product> getAll();

    Product getById(String id);

    Product update(Product product);

    void deleteById(String id);

    List<Product> getAllById(List<String> productsId);
}
