package com.csrentbd.controller;

import com.csrentbd.model.Space;
import com.csrentbd.model.User;
import com.csrentbd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.add(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        try {
            User deleted = service.delete(id);
            return ResponseEntity.ok(deleted);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id); // Asegura que el ID se mantiene correcto
        return ResponseEntity.ok(service.edit(user));
    }
}
