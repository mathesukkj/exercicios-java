package com.mathesukkj.springcourse.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mathesukkj.springcourse.entities.User;
import com.mathesukkj.springcourse.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping // default mapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}") // custom mapping
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        User foundUser = service.findById(id);
        return ResponseEntity.ok().body(foundUser);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(user));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id) {
        return ResponseEntity.ok().body(service.update(id, user));
    }
}
