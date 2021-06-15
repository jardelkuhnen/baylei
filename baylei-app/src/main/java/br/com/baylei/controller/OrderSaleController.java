package br.com.baylei.controller;

import br.com.baylei.dto.OrderSaleDTO;
import br.com.baylei.service.OrderSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-sale")
public class OrderSaleController {

    @Autowired
    private OrderSaleService orderSaleService;


    @PostMapping
    public ResponseEntity<OrderSaleDTO> save(@RequestBody OrderSaleDTO orderSaleDTO) {
        return new ResponseEntity<>(orderSaleService.save(orderSaleDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderSaleDTO> update(@RequestBody OrderSaleDTO orderSaleDTO) {
        return new ResponseEntity<>(orderSaleService.update(orderSaleDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderSaleDTO>> getAll() {
        return new ResponseEntity<>(orderSaleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderSaleDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(orderSaleService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        this.orderSaleService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}
