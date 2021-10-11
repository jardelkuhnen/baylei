package br.com.baylei.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class BaseEntity {

    @Id
    @Column
    private String id;
    @Column
    private LocalDateTime dateCreated;
    @Column
    private LocalDateTime dateUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
