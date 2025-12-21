package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "vehicle_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_service_vehicle")
    )
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "garage_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_service_garage")
    )
    private Garage garage;

    @Column(nullable = false)
    private String serviceType;

    @Column(nullable = false)
    private LocalDate serviceDate;

    @Column(nullable = false)
    private Integer odometerReading;

    @OneToMany(
        mappedBy = "serviceEntry",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<ServicePart> serviceParts;

    public ServiceEntry() {}

    public ServiceEntry(Vehicle vehicle, Garage garage, String serviceType,
                        LocalDate serviceDate, Integer odometerReading) {
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
    }

    // Getters & Setters
    public Vehicle getVehicle() { return vehicle; }

public Garage getGarage() { return garage; }

public Date getServiceDate() { return serviceDate; }

public Integer getOdometerReading() { return odometerReading; }

public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

public void setGarage(Garage garage) { this.garage = garage; }

}
