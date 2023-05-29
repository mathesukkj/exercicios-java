package com.mathesukkj.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesukkj.springcourse.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
