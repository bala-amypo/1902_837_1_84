package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDate date;
    private int odometerReading;

    @ManyToOne
    private Vehicle vehicle;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getOdometerReading() { return odometerReading; }
    public void setOdometerReading(int odometerReading) { this.odometerReading = odometerReading; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
