package br.com.baylei.adapter;

import br.com.baylei.entity.PlanEntity;
import br.com.baylei.model.Plan;
import br.com.baylei.usecase.PlanPersistencePort;
import br.com.baylei.repository.PlanRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlanSpringJpaAdapter implements PlanPersistencePort {

    private final PlanRepository planRepository;

    public PlanSpringJpaAdapter(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Plan save(Plan plan) {
        var planEntity = new PlanEntity();
        BeanUtils.copyProperties(plan, planEntity);
        BeanUtils.copyProperties(planRepository.save(planEntity), plan);
        return plan;
    }

    @Override
    public List<Plan> getAll() {
        List<Plan> plans = new ArrayList<>();
        List<PlanEntity> planEntities = planRepository.findAll();

        for (PlanEntity entity : planEntities) {
            var plan = new Plan();
            BeanUtils.copyProperties(entity, plan);
            plans.add(plan);
        }

        return plans;
    }

    @Override
    public Plan getById(String id) {
        Optional<PlanEntity> planEntityOptional = planRepository.findById(id);

        if (!planEntityOptional.isPresent()) {
            return null;
        }

        var plan = new Plan();
        BeanUtils.copyProperties(planEntityOptional.get(), plan);

        return plan;
    }

    @Override
    public Plan update(Plan plan) {
        Optional<PlanEntity> planEntityOptional = planRepository.findById(plan.getId());

        if (!planEntityOptional.isPresent()) {
            return null;
        }

        var planEntity = planEntityOptional.get();
        BeanUtils.copyProperties(plan, planEntity);
        BeanUtils.copyProperties(planRepository.save(planEntity), plan);

        return plan;
    }

    @Override
    public void deleteById(String id) {
        planRepository.deleteById(id);
    }

    @Override
    public List<Plan> getAllById(List<String> ids) {
        List<Plan> plans = new ArrayList<>();
        planRepository.findAllById(ids).forEach(entity -> {
            var plan = new Plan();
            BeanUtils.copyProperties(entity, plan);
            plans.add(plan);
        });

        return plans;
    }
}
