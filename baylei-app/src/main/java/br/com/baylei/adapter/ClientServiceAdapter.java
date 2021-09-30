package br.com.baylei.adapter;

import br.com.baylei.api.ClientService;
import br.com.baylei.dto.ClientDTO;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.model.Client;
import br.com.baylei.ports.ClientPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClientServiceAdapter implements ClientService {

    private final ClientPersistencePort clientPersistencePort;

    @Autowired
    public ClientServiceAdapter(ClientPersistencePort clientPersistencePort) {
        this.clientPersistencePort = clientPersistencePort;
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        var client = ClientDTO.ofDto(clientDTO);
        client.setDateCreated(LocalDateTime.now());
        return ClientDTO.of(clientPersistencePort.save(client));
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {
        var client = clientPersistencePort.getById(clientDTO.getId());

        if (Objects.isNull(client)) {
            throw new NotFoundException("Não localizado cliente com id -> " + clientDTO.getId());
        }

        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setAge(clientDTO.getAge());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        client.setDateUpdated(LocalDateTime.now());

        return ClientDTO.of(clientPersistencePort.save(client));
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clients = clientPersistencePort.getAll();

        return clients.stream().map(ClientDTO::of).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getById(String id) {
        var client = clientPersistencePort.getById(id);

        if (Objects.isNull(client)) {
            throw new NotFoundException("Não localizado client com id -> " + id);
        }

        return ClientDTO.of(client);
    }

    @Override
    public void deleteById(String id) {
        clientPersistencePort.deleteById(id);
    }

    @Override
    public List<ClientDTO> findByIds(List<String> clientsId) {
        List<Client> clientsFound = new ArrayList<>();

        clientPersistencePort.getAllById(clientsId).forEach(clientsFound::add);

        return clientsFound.stream().map(ClientDTO::of).collect(Collectors.toList());
    }
}
