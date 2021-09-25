package br.com.baylei.dto;

import br.com.baylei.entity.Plan;
import br.com.baylei.entity.Product;
import br.com.baylei.model.Client;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class PlanDTO {

    private String id;
    @NotBlank(message = "Nome deve ser informado")
    private String name;
    private String description;
    @NotNull(message = "Clientes devem ser informados")
    private List<ClientDTO> clients;
    @NotNull(message = "Produtos devem ser informados")
    private List<ProductDTO> products;
    @NotNull(message = "Quantidade por produto deve ser informada")
    private Integer ammount;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public static PlanDTO of(Plan plan, List<Product> products, List<Client> clients) {
        return PlanDTO.builder()
                .id(plan.getId())
                .name(plan.getName())
                .description(plan.getDescription())
                .clients(clients.stream().map(c -> ClientDTO.of(c)).collect(Collectors.toList()))
                .products(products.stream().map(p -> ProductDTO.of(p)).collect(Collectors.toList()))
                .ammount(plan.getAmmount())
                .dateCreated(plan.getDateCreated())
                .dateUpdated(plan.getDateUpdated())
                .build();
    }

    public static Plan of(PlanDTO planDTO) {
        Plan plan = new Plan();
        plan.setName(planDTO.getName());
        plan.setAmmount(planDTO.getAmmount());
        plan.setDescription(planDTO.getDescription());
        plan.setClientsId(planDTO.getClients().stream().map(c -> c.getId()).collect(Collectors.toList()));
        plan.setProductIds(planDTO.getProducts().stream().map(p -> p.getId()).collect(Collectors.toList()));

        return plan;
    }
}
