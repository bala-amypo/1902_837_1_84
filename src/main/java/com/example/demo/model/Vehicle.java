package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vin;

    private String make;
    private String model;
    private Long ownerId;
    private boolean active = true;

    @OneToMany(mappedBy = "vehicle")
    private Set<ServiceEntry> serviceEntries = new HashSet<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
