package br.com.baylei.repository;

import br.com.baylei.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("client-repository-mongo")
public interface ClientRepository extends MongoRepository<ClientEntity, String> {
}
