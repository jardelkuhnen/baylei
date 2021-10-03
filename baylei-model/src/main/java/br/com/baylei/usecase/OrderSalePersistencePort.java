package br.com.baylei.usecase;

import br.com.baylei.model.OrderSale;

import java.util.List;

public interface OrderSalePersistencePort {

    OrderSale save(OrderSale orderSale);

    List<OrderSale> getAll();

    OrderSale getById(String id);

    OrderSale update(OrderSale orderSale);

    void deleteById(String id);

    List<OrderSale> getAllById(List<String> ids);

}
