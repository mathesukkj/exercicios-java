package com.mathesukkj.apirestful.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathesukkj.apirestful.domain.Post;
import com.mathesukkj.apirestful.resources.util.URL;
import com.mathesukkj.apirestful.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Post>> findByBody(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(service.findByBody(text));
    }

    @GetMapping(value = "/author")
    public ResponseEntity<List<Post>> findByAuthor(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(service.findByAuthor(text));
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        LocalDate min = URL.convertDate(minDate, LocalDate.now());
        LocalDate max = URL.convertDate(maxDate, LocalDate.now());
        return ResponseEntity.ok().body(service.fullSearch(text, min, max));
    }
}
