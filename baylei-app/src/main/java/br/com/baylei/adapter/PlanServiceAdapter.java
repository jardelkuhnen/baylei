package br.com.baylei.adapter;

import br.com.baylei.api.PlanService;
import br.com.baylei.dto.PlanDTO;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.model.Client;
import br.com.baylei.model.Plan;
import br.com.baylei.model.Product;
import br.com.baylei.ports.ClientPersistencePort;
import br.com.baylei.ports.PlanPersistencePort;
import br.com.baylei.ports.ProductPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlanServiceAdapter implements PlanService {

    private final PlanPersistencePort planPersistencePort;
    private final ProductPersistencePort productPersistencePort;
    private final ClientPersistencePort clientPersistencePort;

    @Autowired
    public PlanServiceAdapter(PlanPersistencePort planPersistencePort,
                              ProductPersistencePort productPersistencePort,
                              ClientPersistencePort clientPersistencePort) {
        this.planPersistencePort = planPersistencePort;
        this.productPersistencePort = productPersistencePort;
        this.clientPersistencePort = clientPersistencePort;
    }

    @Override
    public PlanDTO save(PlanDTO planDTO) {
        var plan = PlanDTO.of(planDTO);

        plan.setDateCreated(LocalDateTime.now());

        List<Product> productEntities = productPersistencePort.getAllById(plan.getProductIds());
        List<Client> clients = clientPersistencePort.getAllById(plan.getClientsId());

        return PlanDTO.of(planPersistencePort.save(plan), productEntities, clients);
    }

    @Override
    public PlanDTO update(PlanDTO planDTO) {
        var plan = PlanDTO.of(planDTO);

        List<Product> productEntities = productPersistencePort.getAllById(plan.getProductIds());
        List<Client> clients = clientPersistencePort.getAllById(plan.getClientsId());

        return PlanDTO.of(planPersistencePort.save(plan), productEntities, clients);
    }

    @Override
    public List<PlanDTO> getAll() {
        List<PlanDTO> dtos = new ArrayList<>();
        List<Plan> planEntities = planPersistencePort.getAll();

        for (Plan planEntity : planEntities) {
            List<Product> productEntities = productPersistencePort.getAllById(planEntity.getProductIds());
            List<Client> clients = clientPersistencePort.getAllById(planEntity.getClientsId());

            dtos.add(PlanDTO.of(planEntity, productEntities, clients));
        }

        return dtos;
    }

    @Override
    public PlanDTO getById(String id) {
        Plan plan = planPersistencePort.getById(id);

        if (Objects.isNull(plan)) {
            throw new NotFoundException("Não localizado Plano para o id -> " + id);
        }

        List<Product> productEntities = productPersistencePort.getAllById(plan.getProductIds());
        List<Client> clients = clientPersistencePort.getAllById(plan.getClientsId());

        return PlanDTO.of(plan, productEntities, clients);
    }

    @Override
    public void deleteById(String id) {
        planPersistencePort.deleteById(id);
    }
}
