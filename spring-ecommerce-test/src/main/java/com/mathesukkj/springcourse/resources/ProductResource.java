package com.mathesukkj.springcourse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathesukkj.springcourse.entities.Product;
import com.mathesukkj.springcourse.services.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductResource {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Product foundProduct = service.findById(id);
        return ResponseEntity.ok().body(foundProduct);
    }
}
