package com.mathesukkj.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesukkj.springcourse.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
