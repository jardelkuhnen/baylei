package br.com.baylei.repository;

import br.com.baylei.entity.SellerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<SellerEntity, String> {
}
