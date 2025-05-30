package com.csrentbd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Space")
public class Space implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double areaInSquareMeters;
    private int capacity;

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

    public double getAreaInSquareMeters() {
        return areaInSquareMeters;
    }

    public void setAreaInSquareMeters(double areaInSquareMeters) {
        this.areaInSquareMeters = areaInSquareMeters;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
