package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "garage_id", nullable = false)
    private Garage garage;

    private String serviceType;

    @Column(nullable = false)
    private LocalDate serviceDate;

    @Column(nullable = false)
    private Integer odometerReading;

    private String description;

    private Timestamp recordedAt = new Timestamp(System.currentTimeMillis());

    @OneToMany(mappedBy = "serviceEntry", fetch = FetchType.LAZY)
    private List<ServicePart> serviceParts;

    public ServiceEntry() {}

    // GETTERS
    public Long getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public Garage getGarage() { return garage; }
    public String getServiceType() { return serviceType; }
    public LocalDate getServiceDate() { return serviceDate; }
    public Integer getOdometerReading() { return odometerReading; }
    public String getDescription() { return description; }
    public Timestamp getRecordedAt() { return recordedAt; }

    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setGarage(Garage garage) { this.garage = garage; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }
    public void setOdometerReading(Integer odometerReading) { this.odometerReading = odometerReading; }
    public void setDescription(String description) { this.description = description; }
    public void setRecordedAt(Timestamp recordedAt) { this.recordedAt = recordedAt; }
}
