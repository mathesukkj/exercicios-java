package com.mathesukkj.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesukkj.springcourse.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
