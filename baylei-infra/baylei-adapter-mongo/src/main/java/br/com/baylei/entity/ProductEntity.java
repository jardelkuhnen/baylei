package br.com.baylei.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
@CompoundIndexes({
        @CompoundIndex(name = "_name", def = "{'name' : 1}"),
        @CompoundIndex(name = "_description", def = "{'description' : 1}"),
})
public class ProductEntity extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;

}
