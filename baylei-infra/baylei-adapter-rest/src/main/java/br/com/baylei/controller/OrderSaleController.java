package br.com.baylei.controller;

import br.com.baylei.api.OrderSaleService;
import br.com.baylei.dto.OrderSaleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags ={"Order service"} )
@RestController
@RequestMapping("/api/orders")
public class OrderSaleController {

    @Autowired
    private OrderSaleService orderSaleService;


    @PostMapping
    @ApiOperation("Save order")
    public ResponseEntity<OrderSaleDTO> save(@RequestBody @Validated OrderSaleDTO orderSaleDTO) {
        return new ResponseEntity<>(orderSaleService.save(orderSaleDTO), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Update order")
    public ResponseEntity<OrderSaleDTO> update(@RequestBody @Validated OrderSaleDTO orderSaleDTO) {
        return new ResponseEntity<>(orderSaleService.update(orderSaleDTO), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Get all orders")
    public ResponseEntity<List<OrderSaleDTO>> getAll() {
        return new ResponseEntity<>(orderSaleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get order by id")
    public ResponseEntity<OrderSaleDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(orderSaleService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete order by id")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        this.orderSaleService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

}
