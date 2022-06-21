package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.service.IOrderService;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("orders")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping
    public ResponseEntity<Iterable<Order>> findAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Order> add(@RequestBody Order order){
        orderService.save(order);
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable long id){
        return new ResponseEntity<>(orderService.findById(id).get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> edit(@RequestBody Order order,@PathVariable long id){
        order.setId(id);
        orderService.save(order);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable long id){
        orderService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
