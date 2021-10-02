package br.com.baylei.dto;

import br.com.baylei.model.Client;
import br.com.baylei.model.Plan;
import br.com.baylei.model.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PlanDTO {

    private String id;
    private String name;
    private String description;
    private List<ClientDTO> clients;
    private List<ProductDTO> products;
    private Integer ammount;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public static PlanDTO of(Plan plan, List<Product> products, List<Client> clients) {
        var dto = new PlanDTO();
        dto.setId(plan.getId());
        dto.setName(plan.getName());
        dto.setDescription(plan.getDescription());
        dto.setClients(clients.stream().map(client -> ClientDTO.of(client)).collect(Collectors.toList()));
        dto.setProducts(products.stream().map(product -> ProductDTO.of(product)).collect(Collectors.toList()));
        dto.setAmmount(plan.getAmmount());
        dto.setDateCreated(plan.getDateCreated());
        dto.setDateUpdated(plan.getDateUpdated());

        return dto;
    }

    public static Plan of(PlanDTO planDTO) {
        Plan planEntity = new Plan();
        planEntity.setName(planDTO.getName());
        planEntity.setAmmount(planDTO.getAmmount());
        planEntity.setDescription(planDTO.getDescription());
        planEntity.setClientsId(planDTO.getClients().stream().map(c -> c.getId()).collect(Collectors.toList()));
        planEntity.setProductIds(planDTO.getProducts().stream().map(p -> p.getId()).collect(Collectors.toList()));

        return planEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClientDTO> getClients() {
        return clients;
    }

    public void setClients(List<ClientDTO> clients) {
        this.clients = clients;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
