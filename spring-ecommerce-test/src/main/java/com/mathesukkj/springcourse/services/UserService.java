package com.mathesukkj.springcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mathesukkj.springcourse.entities.User;
import com.mathesukkj.springcourse.repositories.UserRepository;
import com.mathesukkj.springcourse.services.exceptions.DatabaseException;
import com.mathesukkj.springcourse.services.exceptions.MissingArgumentsException;
import com.mathesukkj.springcourse.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null
                || user.getPhone() == null) {
            throw new MissingArgumentsException();
        }
        return repository.save(user);
    }

    public void delete(Integer id) {
        try {
            findById(id);
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Integer id, User user) {
        try {
            if (user.getName() == null || user.getEmail() == null || user.getPhone() == null) {
                throw new MissingArgumentsException();
            }
            User ent = repository.getReferenceById(id);
            updateData(ent, user);
            return repository.save(ent);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User ent, User user) {
        ent.setName(user.getName());
        ent.setEmail(user.getEmail());
        ent.setPhone(user.getPhone());
    }
}
