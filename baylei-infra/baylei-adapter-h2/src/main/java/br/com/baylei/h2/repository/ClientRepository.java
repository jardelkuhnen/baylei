package br.com.baylei.h2.repository;

import br.com.baylei.h2.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("client-repository-h2")
public interface ClientRepository extends JpaRepository<ClientEntity, String> {


}
