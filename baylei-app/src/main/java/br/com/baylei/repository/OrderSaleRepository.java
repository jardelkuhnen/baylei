package br.com.baylei.repository;

import br.com.baylei.entity.OrderSale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSaleRepository extends MongoRepository<OrderSale, String> {
}
