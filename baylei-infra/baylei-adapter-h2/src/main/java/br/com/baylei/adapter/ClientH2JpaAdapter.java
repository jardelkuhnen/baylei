package br.com.baylei.adapter;

import br.com.baylei.entity.ClientEntity;
import br.com.baylei.model.Client;
import br.com.baylei.repository.ClientRepository;
import br.com.baylei.usecase.ClientPersistencePort;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientH2JpaAdapter implements ClientPersistencePort {

    private final ClientRepository clientRepository;

    public ClientH2JpaAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return null;
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
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Client> getAllById(List<String> clientsId) {
        return null;
    }
}
