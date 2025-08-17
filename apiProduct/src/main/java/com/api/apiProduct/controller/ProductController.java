package com.api.apiProduct.controller;

import com.api.apiProduct.model.Product;
import com.api.apiProduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class ProductController {
    @Autowired
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product>getAll(){
        return productService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product){
        try {
            Product created = productService.save(product);
            URI location = URI.create("/task/" + created.getId());
            return ResponseEntity.created(location).body(created);

        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product ){
        try {
            Product update = productService.update(id,product);
            return ResponseEntity.ok(update);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return productService.delete(id);
    }



}
