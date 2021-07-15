package br.com.baylei.controller;


import br.com.baylei.dto.SellerDTO;
import br.com.baylei.service.SellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags ={"Seller service"} )
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    @ApiOperation("Save seller")
    public ResponseEntity<SellerDTO> save(@RequestBody SellerDTO sellerDTO) {
        return new ResponseEntity<>(sellerService.save(sellerDTO), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update seller")
    public ResponseEntity<SellerDTO> update(@RequestBody SellerDTO sellerDTO) {
        return new ResponseEntity<>(sellerService.update(sellerDTO), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Get all sellers")
    public ResponseEntity<List<SellerDTO>> getAll() {
        return new ResponseEntity<>(sellerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get seller by id")
    public ResponseEntity<SellerDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(sellerService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete seller by id")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        this.sellerService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}

