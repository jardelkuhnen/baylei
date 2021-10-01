package br.com.baylei.service;

import br.com.baylei.api.ClientService;
import br.com.baylei.api.ProductService;
import br.com.baylei.dto.ClientDTO;
import br.com.baylei.dto.PlanDTO;
import br.com.baylei.dto.ProductDTO;
import br.com.baylei.entity.Plan;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    private final PlanRepository planRepository;
    private final ProductService productService;
    private final ClientService clientService;

    @Autowired
    public PlanService(PlanRepository planRepository, ProductService productService, ClientService clientService) {
        this.planRepository = planRepository;
        this.productService = productService;
        this.clientService = clientService;
    }

    public PlanDTO save(PlanDTO planDTO) {
        var plan = PlanDTO.of(planDTO);

        plan.setDateCreated(LocalDateTime.now());

        List<ProductDTO> productEntities = productService.findByIds(plan.getProductIds());
        List<ClientDTO> clients = clientService.findByIds(plan.getClientsId());

        return PlanDTO.of(planRepository.save(plan), productEntities, clients);
    }

    public PlanDTO update(PlanDTO planDTO) {

        var plan = PlanDTO.of(planDTO);

        List<ProductDTO> productEntities = productService.findByIds(plan.getProductIds());
        List<ClientDTO> clients = clientService.findByIds(plan.getClientsId());

        return PlanDTO.of(planRepository.save(plan), productEntities, clients);

    }

    public List<PlanDTO> getAll() {

        List<PlanDTO> dtos = new ArrayList<>();
        List<Plan> plans = planRepository.findAll();

        for (Plan plan : plans) {
            List<ProductDTO> productEntities = productService.findByIds(plan.getProductIds());
            List<ClientDTO> clients = clientService.findByIds(plan.getClientsId());

            dtos.add(PlanDTO.of(plan, productEntities, clients));
        }

        return dtos;
    }

    public PlanDTO getById(String id) {

        Optional<Plan> planOptional = planRepository.findById(id);

        if (!planOptional.isPresent()) {
            throw new NotFoundException("Não localizado Plano para o id -> " + id);
        }

        var plan = planOptional.get();

        List<ProductDTO> productEntities = productService.findByIds(plan.getProductIds());
        List<ClientDTO> clients = clientService.findByIds(plan.getClientsId());

        return PlanDTO.of(plan, productEntities, clients);
    }

    public void deleteById(String id) {
        planRepository.deleteById(id);
    }
}
