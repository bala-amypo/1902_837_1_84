package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String manufacturer;
    private int year;
    private boolean active;

    // Constructors
    public Vehicle() {}
    public Vehicle(Long id, String model, String manufacturer, int year, boolean active) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
