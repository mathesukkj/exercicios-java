package com.mathesukkj.apirestful.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mathesukkj.apirestful.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
}
