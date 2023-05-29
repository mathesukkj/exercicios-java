package com.mathesukkj.springcourse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathesukkj.springcourse.entities.Order;
import com.mathesukkj.springcourse.services.OrderService;

@RestController
@RequestMapping(path = "/orders")
public class OrderResource {
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
        Order foundOrder = service.findById(id);
        return ResponseEntity.ok().body(foundOrder);
    }
}
