package br.com.baylei.controller;

import br.com.baylei.api.ClientService;
import br.com.baylei.dto.ClientDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"Client service"})
@RequestMapping("/api/clients")
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<ClientDTO> save(ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.save(clientDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClientDTO> update(ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.update(clientDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientDTO>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDTO> getById(String id) {
        return new ResponseEntity<>(clientService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(String id) {
        clientService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
