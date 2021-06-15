package br.com.baylei.controller;

import br.com.baylei.dto.ProductDTO;
import br.com.baylei.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.update(productDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        this.productService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }


}
