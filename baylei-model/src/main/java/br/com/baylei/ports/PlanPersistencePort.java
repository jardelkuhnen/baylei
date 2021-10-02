package br.com.baylei.ports;

import br.com.baylei.model.Plan;

import java.util.List;

public interface PlanPersistencePort {

    Plan save(Plan plan);

    List<Plan> getAll();

    Plan getById(String id);

    Plan update(Plan plan);

    void deleteById(String id);

    List<Plan> getAllById(List<String> ids);

}
