package br.com.baylei.usecase;

import br.com.baylei.model.Client;

import java.util.List;

public interface ClientPersistencePort {

    Client save(Client client);

    List<Client> getAll();

    Client getById(String id);

    Client update(Client client);

    void deleteById(String id);

    List<Client> getAllById(List<String> clientsId);
}
