package br.com.baylei.h2.adapter;

import br.com.baylei.h2.entity.ClientEntity;
import br.com.baylei.h2.repository.ClientRepository;
import br.com.baylei.model.Client;
import br.com.baylei.usecase.ClientPersistencePort;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientH2JpaAdapter implements ClientPersistencePort {

    private final ClientRepository clientRepository;

    public ClientH2JpaAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        var clientEntity = new ClientEntity();
        BeanUtils.copyProperties(client, clientEntity);
        clientEntity.setId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(clientRepository.save(clientEntity), client);
        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        List<ClientEntity> clientEntities = clientRepository.findAll();

        for (ClientEntity entity : clientEntities) {
            var client = new Client();
            BeanUtils.copyProperties(entity, client);
            clients.add(client);
        }

        return clients;
    }

    @Override
    public Client getById(String id) {
        Optional<ClientEntity> clientEntityOptional = clientRepository.findById(id);

        if (clientEntityOptional.isEmpty()) {
            return null;
        }

        var client = new Client();
        BeanUtils.copyProperties(clientEntityOptional.get(), client);

        return client;
    }

    @Override
    public Client update(Client client) {
        Optional<ClientEntity> clientEntityOptional = clientRepository.findById(client.getId());

        if (clientEntityOptional.isPresent()) {
            return null;
        }

        var clientEntity = clientEntityOptional.get();
        BeanUtils.copyProperties(client, clientEntity);
        BeanUtils.copyProperties(clientRepository.save(clientEntity), client);

        return client;
    }

    @Override
    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAllById(List<String> clientsId) {
        List<Client> clients = new ArrayList<>();

        clientRepository.findAllById(clientsId).forEach(clientEntity -> {
            var client = new Client();
            BeanUtils.copyProperties(clientEntity, client);
            clients.add(client);
        });

        return clients;
    }
}
