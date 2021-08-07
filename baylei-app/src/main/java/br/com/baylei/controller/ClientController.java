package br.com.baylei.controller;

import br.com.baylei.dto.ClientDTO;
import br.com.baylei.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags ={"Client service"} )
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ApiOperation("Save client")
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.save(clientDTO), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update client")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.update(clientDTO), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Get all clients")
    public ResponseEntity<List<ClientDTO>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get client by id")
    public ResponseEntity<ClientDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(clientService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete cliente by id")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        this.clientService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}
