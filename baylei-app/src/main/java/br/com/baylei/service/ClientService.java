package br.com.baylei.service;

import br.com.baylei.dto.ClientDTO;
import br.com.baylei.entity.Client;
import br.com.baylei.exception.NotFoundException;
import br.com.baylei.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO save(ClientDTO clientDTO) {

        var client = ClientDTO.ofDto(clientDTO);
        client.setDateCreated(LocalDateTime.now());

        return ClientDTO.of(clientRepository.save(client));
    }

    public ClientDTO update(ClientDTO clientDTO) {
        var clientOptional = clientRepository.findById(clientDTO.getId());

        if(clientOptional.isEmpty()) {
            throw new NotFoundException("Não localizado cliente com id -> " + clientDTO.getId());
        }

        var client = clientOptional.get();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setAge(clientDTO.getAge());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        client.setDateUpdated(LocalDateTime.now());

        return ClientDTO.of(clientRepository.save(client));
    }

    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map(ClientDTO::of).collect(Collectors.toList());
    }

    public ClientDTO getById(String id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if (clientOptional.isEmpty()) {
            throw new NotFoundException("Não localizado client com id -> " + id);
        }

        return ClientDTO.of(clientOptional.get());
    }

    public void deleteById(String id) {
        this.clientRepository.deleteById(id);
    }
}
