package br.com.baylei.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    private String id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
