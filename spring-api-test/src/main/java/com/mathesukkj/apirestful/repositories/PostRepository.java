package com.mathesukkj.apirestful.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mathesukkj.apirestful.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByBodyContainingIgnoreCase(String text);

    @Query("{ 'author.name': { $regex: ?0, $options: 'i' } }")
    List<Post> findByAuthorIgnoreCase(String text);

    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);
}
