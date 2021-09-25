package br.com.baylei.repository;

import br.com.baylei.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {
}
