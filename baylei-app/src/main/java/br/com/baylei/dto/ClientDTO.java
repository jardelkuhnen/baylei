package br.com.baylei.dto;

import br.com.baylei.entity.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {

    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String phone;
    private String email;


    public static ClientDTO of(Client client) {
        return ClientDTO.builder()
                .name(client.getName())
                .lastName(client.getLastName())
                .age(client.getAge())
                .email(client.getEmail())
                .phone(client.getPhone())
                .id(client.getId()).build();
    }

    public static Client ofDto(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setAge(clientDTO.getAge());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());

        return client;
    }
}
