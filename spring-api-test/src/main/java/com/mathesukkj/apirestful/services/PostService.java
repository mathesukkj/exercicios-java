package com.mathesukkj.apirestful.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathesukkj.apirestful.domain.Post;
import com.mathesukkj.apirestful.repositories.PostRepository;
import com.mathesukkj.apirestful.services.exceptions.NotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Object not found!"));
    }

    public List<Post> findByBody(String text) {
        return repo.findByBodyContainingIgnoreCase(text);
    }

    public List<Post> findByAuthor(String text) {
        return repo.findByAuthorIgnoreCase(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        maxDate.plusDays(1);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
