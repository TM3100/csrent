package com.csrentbd.repository;

import com.csrentbd.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpaceRepository extends JpaRepository<Space,Integer> {
    List<Space> findAllByOrderByIdAsc();
}
