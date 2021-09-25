package br.com.baylei.adapter;

import br.com.baylei.entity.ClientEntity;
import br.com.baylei.model.Client;
import br.com.baylei.ports.ClientPersistencePort;
import br.com.baylei.repository.ClientRepository;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class ClientSpringJpaAdapter implements ClientPersistencePort {

    private ClientRepository clientRepository;

    public ClientSpringJpaAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(client, clientEntity);
        BeanUtils.copyProperties(client, clientRepository.save(clientEntity));
        return client;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Client getById(String id) {
        return null;
    }

    @Override
    public Client update(Client clientDTO) {
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
