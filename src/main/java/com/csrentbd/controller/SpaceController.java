package com.csrentbd.controller;

import com.csrentbd.model.Space;


import com.csrentbd.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/space")
public class SpaceController {

    @Autowired
    private SpaceService service;

    @GetMapping
    public List<Space> getAllSpaces() {
        return service.getAllOrdered();//service.getAll();
    }

    @PostMapping
    public Space createSpace(@RequestBody Space space) {
        return service.add(space);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Space> getSpace(@PathVariable Integer id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Space> deleteSpace(@PathVariable Integer id) {
        try {
            Space deleted = service.delete(id);
            return ResponseEntity.ok(deleted);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Space> updateSpace(@PathVariable Integer id, @RequestBody Space space) {
        space.setId(id); // Asegura que actualizas el correcto
        return ResponseEntity.ok(service.edit(space));
    }

}
