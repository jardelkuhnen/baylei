package br.com.baylei.controller;

import br.com.baylei.dto.ClientDTO;
import br.com.baylei.entity.Client;
import br.com.baylei.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientDTO save(@RequestBody ClientDTO clientDTO) {
        return clientService.save(clientDTO);
    }

    @PutMapping
    public ClientDTO update(@RequestBody ClientDTO clientDTO) {
        return clientService.update(clientDTO);
    }

    @GetMapping("/all")
    public List<ClientDTO> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientDTO getById(@PathVariable String id) {
        return clientService.getById(id);
    }

}
