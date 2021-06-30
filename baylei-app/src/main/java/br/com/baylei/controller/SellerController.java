package br.com.baylei.controller;


import br.com.baylei.dto.SellerDTO;
import br.com.baylei.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerDTO> save(@RequestBody SellerDTO sellerDTO) {
        return new ResponseEntity<>(sellerService.save(sellerDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SellerDTO> update(@RequestBody SellerDTO sellerDTO) {
        return new ResponseEntity<>(sellerService.update(sellerDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SellerDTO>> getAll() {
        return new ResponseEntity<>(sellerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(sellerService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        this.sellerService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}

