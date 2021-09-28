package br.com.baylei.adapter;

import br.com.baylei.entity.ClientEntity;
import br.com.baylei.model.Client;
import br.com.baylei.ports.ClientPersistencePort;
import br.com.baylei.repository.ClientRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientSpringJpaAdapter implements ClientPersistencePort {

    private final ClientRepository clientRepository;

    public ClientSpringJpaAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        var clientEntity = new ClientEntity();
        BeanUtils.copyProperties(client, clientEntity);
        BeanUtils.copyProperties(client, clientRepository.save(clientEntity));
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

        if (!clientEntityOptional.isPresent()) {
            return null;
        }

        var client = new Client();
        BeanUtils.copyProperties(clientEntityOptional.get(), client);

        return client;
    }

    @Override
    public Client update(Client clientDTO) {
        return null;
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
