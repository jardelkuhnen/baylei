package br.com.baylei.controller;

import br.com.baylei.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientController {

    @PostMapping
    ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO);

    @PutMapping
    ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO);

    @GetMapping
    ResponseEntity<List<ClientDTO>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<ClientDTO> getById(@PathVariable String id);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteById(@PathVariable String id);
}
