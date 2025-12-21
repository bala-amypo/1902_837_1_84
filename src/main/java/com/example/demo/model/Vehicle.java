package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = @UniqueConstraint(columnNames = "vin")
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String vin;

    private String make;
    private String model;
    private Integer year;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private Boolean active = true;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    public Vehicle() {}

    public Long getId() { return id; }
    public String getVin() { return vin; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public Integer getYear() { return year; }
    public Long getOwnerId() { return ownerId; }
    public Boolean getActive() { return active; }
    public Timestamp getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setVin(String vin) { this.vin = vin; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setYear(Integer year) { this.year = year; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    public void setActive(Boolean active) { this.active = active; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
