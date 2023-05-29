package com.mathesukkj.springcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathesukkj.springcourse.entities.Category;
import com.mathesukkj.springcourse.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Integer id) {
        return repository.findById(id).get();
    }
}
