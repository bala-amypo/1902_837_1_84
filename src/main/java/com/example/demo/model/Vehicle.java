package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String vin;

    private String ownerName;
    private Boolean active = true;

    public Vehicle() {}

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
