package br.com.baylei.dto;

import br.com.baylei.model.Client;

import java.time.LocalDateTime;

public class ClientDTO {

    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String phone;
    private String email;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public static ClientDTO of(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setLastName(client.getLastName());
        dto.setAge(client.getAge());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        dto.setDateCreated(client.getDateCreated());
        dto.setDateUpdated(client.getDateUpdated());

        return dto;
    }

    public static Client ofDto(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setAge(clientDTO.getAge());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());

        return client;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
