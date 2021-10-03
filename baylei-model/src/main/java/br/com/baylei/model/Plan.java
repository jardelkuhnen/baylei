package br.com.baylei.model;

import java.util.List;

public class Plan extends BaseModel {

    private String name;
    private Integer ammount;
    private String description;
    private List<String> clientsId;
    private List<String> productIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getClientsId() {
        return clientsId;
    }

    public void setClientsId(List<String> clientsId) {
        this.clientsId = clientsId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}
