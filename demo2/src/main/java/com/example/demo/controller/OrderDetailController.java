package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.service.IOrderDetalService;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("order-detail")
public class OrderDetailController {
    @Autowired
    IOrderDetalService orderDetalService;

    @GetMapping
    public ResponseEntity<Iterable<OrderDetail>> findAll() {
        return new ResponseEntity<>(orderDetalService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<OrderDetail> add(@RequestBody OrderDetail  orderDetail){
        orderDetalService.save(orderDetail);
        return new ResponseEntity<>(orderDetail,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> findById(@PathVariable long id){
        return new ResponseEntity<>(orderDetalService.findById(id).get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> edit(@RequestBody OrderDetail orderDetail,@PathVariable long id){
        orderDetail.setId(id);
        orderDetalService.save(orderDetail);
        return new ResponseEntity<>(orderDetail,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDetail> delete(@PathVariable long id){
        orderDetalService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
