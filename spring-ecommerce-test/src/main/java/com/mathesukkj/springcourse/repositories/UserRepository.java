package com.mathesukkj.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesukkj.springcourse.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
