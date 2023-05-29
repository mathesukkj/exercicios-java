package com.mathesukkj.springcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathesukkj.springcourse.entities.Product;
import com.mathesukkj.springcourse.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Integer id) {
        return repository.findById(id).get();
    }
}
