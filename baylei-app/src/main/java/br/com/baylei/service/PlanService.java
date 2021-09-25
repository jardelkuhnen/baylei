package br.com.baylei.service;

import br.com.baylei.api.ClientService;
import br.com.baylei.dto.PlanDTO;
import br.com.baylei.entity.Plan;
import br.com.baylei.entity.Product;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.model.Client;
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
        Plan plan = PlanDTO.of(planDTO);

        plan.setDateCreated(LocalDateTime.now());

        List<Product> products = productService.findByIds(plan.getProductIds());
//        List<Client> clients = clientService.findByIds(plan.getClientsId());
        List<Client> clients = new ArrayList<>();

        return PlanDTO.of(planRepository.save(plan), products, clients);
    }

    public PlanDTO update(PlanDTO planDTO) {

        var plan = PlanDTO.of(planDTO);

        List<Product> products = productService.findByIds(plan.getProductIds());
//        List<Client> clients = clientService.findByIds(plan.getClientsId());

        List<Client> clients = new ArrayList<>();
        return PlanDTO.of(planRepository.save(plan), products, clients);

    }

    public List<PlanDTO> getAll() {

        List<PlanDTO> dtos = new ArrayList<>();
        List<Plan> plans = planRepository.findAll();

        for (Plan plan : plans) {
            List<Product> products = productService.findByIds(plan.getProductIds());
//            List<Client> clients = clientService.findByIds(plan.getClientsId());

            List<Client> clients = new ArrayList<>();
            dtos.add(PlanDTO.of(plan, products, clients));
        }

        return dtos;
    }

    public PlanDTO getById(String id) {

        Optional<Plan> planOptional = planRepository.findById(id);

        if (!planOptional.isPresent()) {
            throw new NotFoundException("Não localizado Plano para o id -> " + id);
        }

        var plan = planOptional.get();

        List<Product> products = productService.findByIds(plan.getProductIds());
//        List<Client> clients = clientService.findByIds(plan.getClientsId());
        List<Client> clients = new ArrayList<>();
        return PlanDTO.of(plan, products, clients);
    }

    public void deleteById(String id) {
        planRepository.deleteById(id);
    }
}
