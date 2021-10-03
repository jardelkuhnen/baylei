package br.com.baylei.repository;

import br.com.baylei.entity.OrderSaleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderSaleRepository extends MongoRepository<OrderSaleEntity, String> {
}
