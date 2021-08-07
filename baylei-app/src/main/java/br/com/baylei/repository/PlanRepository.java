package br.com.baylei.repository;

import br.com.baylei.entity.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends MongoRepository<Plan, String> {
}
