package br.com.baylei.api;

import br.com.baylei.dto.OrderSaleDTO;

import java.util.List;

public interface OrderSaleService {

    OrderSaleDTO save(OrderSaleDTO orderSaleDTO);

    OrderSaleDTO update(OrderSaleDTO orderSaleDTO);

    List<OrderSaleDTO> getAll();

    OrderSaleDTO getById(String id);

    void deleteById(String id);

}
