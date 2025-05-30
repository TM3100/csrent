package com.csrentbd.service;


import com.csrentbd.model.User;
import com.csrentbd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CRUD<User> {


    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User element) {
        return userRepository.save(element);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> get(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User delete(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            userRepository.deleteById(id);
            return optional.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User edit(User element) {
        return userRepository.save(element);
    }
}

