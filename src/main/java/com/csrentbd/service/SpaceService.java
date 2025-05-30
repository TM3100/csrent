package com.csrentbd.service;

import com.csrentbd.model.Space;
import com.csrentbd.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService implements CRUD<Space>{


    @Autowired
    SpaceRepository spaceRepository;

    @Override
    public Space add(Space element) {
        return spaceRepository.save(element);
    }

    @Override
    public List<Space> getAll() {
        return spaceRepository.findAll();
    }

    @Override
    public Optional<Space> get(Integer id) {
        return spaceRepository.findById(id);
    }

    @Override
    public Space delete(Integer id) {
        Optional<Space> optional = spaceRepository.findById(id);
        if (optional.isPresent()) {
            spaceRepository.deleteById(id);
            return optional.get();
        } else {
            throw new RuntimeException("Space not found");
        }
    }

    @Override
    public Space edit(Space element) {
        return spaceRepository.save(element);
    }
}

