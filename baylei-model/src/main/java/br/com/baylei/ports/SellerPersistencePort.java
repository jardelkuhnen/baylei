package br.com.baylei.ports;

import br.com.baylei.model.Seller;

import java.util.List;

public interface SellerPersistencePort {

    Seller save(Seller seller);

    List<Seller> getAll();

    Seller getById(String id);

    Seller update(Seller seller);

    void deleteById(String id);

    List<Seller> getAllById(List<String> sellersId);

}
