package br.com.baylei.service;

import br.com.baylei.api.ClientService;
import br.com.baylei.dto.ClientDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    private ClientDTO clientDTO = startClientDTO();

    private ClientDTO startClientDTO() {
        return ClientDTO.builder()
                .name("Name DTO")
                .lastName("LastName DTO")
                .age(25)
                .phone("459999999")
                .email("email@email.com")
                .build();
    }

    @Test
    void save() {

        ClientDTO saved = clientService.save(clientDTO);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo(clientDTO.getName());
    }

    @Test
    void update() {
        clientService.save(clientDTO);

        ClientDTO updated = clientService.save(clientDTO);

        assertThat(updated).isNotNull();
        assertThat(updated.getId()).isNotNull();
        assertThat(updated.getName()).isEqualTo(clientDTO.getName());
        assertThat(updated.getDateUpdated()).isNotNull();
    }

    @Test
    void getAll() {

        clientService.save(clientDTO);
        clientService.save(clientDTO);
        clientService.save(clientDTO);

        List<ClientDTO> dtos = clientService.getAll();

        assertThat(dtos).isNotNull();
        assertThat(dtos).isNotEmpty();
        assertThat(dtos.size()).isEqualTo(3);
    }

    @Test
    void getById() {

        clientDTO = clientService.save(clientDTO);

        ClientDTO dto = clientService.getById(clientDTO.getId());
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isNotNull();
    }
}