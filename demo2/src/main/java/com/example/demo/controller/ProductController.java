package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("products")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        return new ResponseEntity<>(productService.findById(id).get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@RequestBody Product product,@PathVariable long id){
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable long id){
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
