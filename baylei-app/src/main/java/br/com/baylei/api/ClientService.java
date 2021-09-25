package br.com.baylei.api;

import br.com.baylei.dto.ClientDTO;

import java.util.List;

public interface ClientService {


    ClientDTO save(ClientDTO clientDTO);

    ClientDTO update(ClientDTO clientDTO);

    List<ClientDTO> getAll();

    ClientDTO getById(String id);

    void deleteById(String id);

    List<ClientDTO> findByIds(List<String> clientsId);

}
