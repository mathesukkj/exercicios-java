package com.mathesukkj.apirestful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathesukkj.apirestful.domain.User;
import com.mathesukkj.apirestful.dto.UserDTO;
import com.mathesukkj.apirestful.repositories.UserRepository;
import com.mathesukkj.apirestful.services.exceptions.NotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<UserDTO> findAll() {
        return repo.findAll().stream().map(x -> new UserDTO(x)).toList();
    }

    public User findById(String id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Object not found!"));
    }

    public User insert(User user) {
        if (user.getName() != null && user.getEmail() != null) {
            return repo.insert(user);
        }
        throw new IllegalArgumentException("Missing arguments!");
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User newUser) {
        User user = findById(newUser.getId());
        updateData(user, newUser);
        return repo.save(user);
    }

    public void updateData(User user, User newUser) {
        if (newUser.getName() != null) {
            user.setName(newUser.getName());
        }
        if (newUser.getEmail() != null) {
            user.setEmail(newUser.getEmail());
        }
    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
