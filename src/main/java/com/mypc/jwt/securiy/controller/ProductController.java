package com.mypc.jwt.securiy.controller;

import com.mypc.jwt.securiy.request.ProductRequest;
import com.mypc.jwt.securiy.dtos.QuantityDto;
import com.mypc.jwt.securiy.model.Product;
import com.mypc.jwt.securiy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    ResponseEntity<Product> save(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.create(new Product(productRequest)));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = new ArrayList<>();
        productService.getAll().iterator().forEachRemaining(products::add);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductRequest productRequest, @PathVariable Integer id){
        return ResponseEntity.ok(productService.update(new Product(productRequest), id));
    }

    @PatchMapping("/increment/{id}")
    public ResponseEntity<Product> increment(@PathVariable Integer id, @RequestBody QuantityDto toIncrement){
        return ResponseEntity.ok(productService.increment(id, toIncrement));
    }

    @PatchMapping("/decrement/{id}")
    public ResponseEntity<Product> decrement(@PathVariable Integer id, @RequestBody QuantityDto toDecrement){
        return ResponseEntity.ok(productService.decrement(id, toDecrement));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
}
