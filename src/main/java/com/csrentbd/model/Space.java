package com.csrentbd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Space")
public class Space implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double areaInSquareMeters;
    private Integer capacity;

    public Space() {
    }

    public Space(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAreaInSquareMeters() {
        return areaInSquareMeters;
    }

    public void setAreaInSquareMeters(Double areaInSquareMeters) {
        this.areaInSquareMeters = areaInSquareMeters;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
