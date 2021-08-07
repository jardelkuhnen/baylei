package br.com.baylei.dto;

import br.com.baylei.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
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
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .lastName(client.getLastName())
                .age(client.getAge())
                .email(client.getEmail())
                .phone(client.getPhone())
                .dateCreated(client.getDateCreated())
                .dateUpdated(client.getDateUpdated())
                .build();
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
}
