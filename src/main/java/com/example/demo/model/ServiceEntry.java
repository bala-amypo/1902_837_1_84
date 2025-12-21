package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "service_entry")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

    private String serviceType;

    @Temporal(TemporalType.DATE)
    private Date serviceDate;

    private Integer odometerReading;
    private String description;

    public ServiceEntry() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Garage getGarage() { return garage; }
    public void setGarage(Garage garage) { this.garage = garage; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public Date getServiceDate() { return serviceDate; }
    public void setServiceDate(Date serviceDate) { this.serviceDate = serviceDate; }

    public Integer getOdometerReading() { return odometerReading; }
    public void setOdometerReading(Integer odometerReading) { this.odometerReading = odometerReading; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
