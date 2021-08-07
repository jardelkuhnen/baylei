package br.com.baylei.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Plan extends BaseEntity {

    private String name;
    private Integer ammount;
    private String description;
    private List<String> clientsId;
    private List<String> productIds;



}
