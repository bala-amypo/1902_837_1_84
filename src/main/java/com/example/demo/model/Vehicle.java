package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity                         // Marks this class as JPA Entity
@Table(
    name = "vehicles",
    uniqueConstraints = @UniqueConstraint(columnNames = "vin")
)
public class Vehicle {

    @Id                         // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String vin;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(
        mappedBy = "vehicle",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<ServiceEntry> serviceEntries;

    // No-arg constructor (mandatory)
    public Vehicle() {}

    // Parameterized constructor
    public Vehicle(String vin, String make, String model, Long ownerId, Boolean active) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.ownerId = ownerId;
        this.active = active;
    }

    // Getters & Setters
    public Long getId() { return id; }

public String getVin() { return vin; }

public void setVin(String vin) { this.vin = vin; }

public Boolean getActive() { return active; }

public void setActive(Boolean active) { this.active = active; }

}
