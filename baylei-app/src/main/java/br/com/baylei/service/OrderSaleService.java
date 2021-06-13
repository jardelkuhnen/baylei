package br.com.baylei.service;

import br.com.baylei.repository.OrderSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSaleService {

    private final OrderSaleRepository orderSaleRepository;

    @Autowired
    public OrderSaleService(OrderSaleRepository orderSaleRepository) {
        this.orderSaleRepository = orderSaleRepository;
    }



}
