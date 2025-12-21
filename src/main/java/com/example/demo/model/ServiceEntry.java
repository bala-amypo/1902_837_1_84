package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate serviceDate;
    private Integer odometerReading;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

    public ServiceEntry() {}

    public Long getId() {
        return id;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public Integer getOdometerReading() {
        return odometerReading;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
