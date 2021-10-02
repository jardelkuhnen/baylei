package br.com.baylei.adapter;

import br.com.baylei.entity.OrderSaleEntity;
import br.com.baylei.model.OrderSale;
import br.com.baylei.ports.OrderSalePersistencePort;
import br.com.baylei.repository.OrderSaleRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderSaleSpringJpaAdapter implements OrderSalePersistencePort {

    private final OrderSaleRepository orderSaleRepository;

    public OrderSaleSpringJpaAdapter(OrderSaleRepository orderSaleRepository) {
        this.orderSaleRepository = orderSaleRepository;
    }

    @Override
    public OrderSale save(OrderSale orderSale) {
        var orderSaleEntity = new OrderSaleEntity();
        BeanUtils.copyProperties(orderSale, orderSaleEntity);
        BeanUtils.copyProperties(orderSaleRepository.save(orderSaleEntity), orderSale);
        return orderSale;
    }

    @Override
    public List<OrderSale> getAll() {
        List<OrderSale> orders = new ArrayList<>();
        List<OrderSaleEntity> orderSaleEntitys = orderSaleRepository.findAll();

        for (OrderSaleEntity entity : orderSaleEntitys) {
            var order = new OrderSale();
            BeanUtils.copyProperties(entity, order);
            orders.add(order);
        }

        return orders;
    }

    @Override
    public OrderSale getById(String id) {
        Optional<OrderSaleEntity> orderSaleEntityOptional = orderSaleRepository.findById(id);

        if (!orderSaleEntityOptional.isPresent()) {
            return null;
        }

        var order = new OrderSale();
        BeanUtils.copyProperties(orderSaleEntityOptional.get(), order);

        return order;
    }

    @Override
    public OrderSale update(OrderSale orderSale) {
        Optional<OrderSaleEntity> orderSaleEntityOptional = orderSaleRepository.findById(orderSale.getId());

        if (!orderSaleEntityOptional.isPresent()) {
            return null;
        }

        var orderSaleEntity = orderSaleEntityOptional.get();
        BeanUtils.copyProperties(orderSale, orderSaleEntity);
        BeanUtils.copyProperties(orderSaleRepository.save(orderSaleEntity), orderSale);

        return orderSale;
    }

    @Override
    public void deleteById(String id) {
        orderSaleRepository.deleteById(id);
    }

    @Override
    public List<OrderSale> getAllById(List<String> ids) {
        List<OrderSale> orderSales = new ArrayList<>();
        orderSaleRepository.findAllById(ids).forEach(entity -> {
            var order = new OrderSale();
            BeanUtils.copyProperties(entity, order);
            orderSales.add(order);
        });

        return orderSales;
    }
}
