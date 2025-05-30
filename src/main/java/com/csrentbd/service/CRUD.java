package com.csrentbd.service;

import com.csrentbd.model.Identifiable;

import java.util.List;
import java.util.Optional;

public interface CRUD <T extends Identifiable>  {
    T add(T element);
    List<T> getAll();
    Optional<T> get(Integer id);
    T delete(Integer id);
    T edit(T element);
}
