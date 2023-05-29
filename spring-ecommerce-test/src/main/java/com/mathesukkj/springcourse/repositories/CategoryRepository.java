package com.mathesukkj.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesukkj.springcourse.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
