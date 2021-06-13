//package br.com.baylei.service;
//
//import br.com.baylei.dto.ClientDTO;
//import br.com.baylei.entity.Client;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.time.LocalDateTime;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
////@RunWith(MockitoJUnitRunner.class)
//class ClientServiceTest {
//
//
//    @InjectMocks
//    private ClientService clientService;
//
//    private Client client;
//    private ClientDTO clientDTO;
//
//    @Before
//    public void setup() {
//        client = startClient();
//        clientDTO = startClientDTO();
//    }
//
//    private ClientDTO startClientDTO() {
//        return ClientDTO.builder()
//                .name("Name")
//                .lastName("LastName")
//                .age(25)
//                .phone("459999999")
//                .email("email@email.com")
//                .build();
//    }
//
//    private Client startClient() {
//        Client c = new Client();
//        c.setName("Name");
//        c.setLastName("LastName");
//        c.setPhone("4599999999");
//        c.setEmail("email@email.com");
//        c.setDateCreated(LocalDateTime.now());
//        c.setAge(25);
//
//        return c;
//    }
//
////    @Test
//    void save() {
//
//        ClientDTO saved = clientService.save(clientDTO);
//
//        assertThat(saved).isNotNull();
//        assertThat(saved.getId()).isNotNull();
//        assertThat(saved.getName()).isEqualTo(clientDTO.getName());
//    }
//
////    @Test
//    void update() {
//    }
//
////    @Test
//    void getAll() {
//    }
//
//    @Test
//    void getById() {
//    }
//}