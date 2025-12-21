package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

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

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date serviceDate;

    @Column(nullable = false)
    private Integer odometerReading;

    @OneToMany(
        mappedBy = "serviceEntry",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<ServicePart> serviceParts;

    @Column(nullable = false)
    private Timestamp recordedAt;

    public ServiceEntry() {
        this.recordedAt = new Timestamp(System.currentTimeMillis());
    }

    public ServiceEntry(
            Vehicle vehicle,
            Garage garage,
            String serviceType,
            Date serviceDate,
            Integer odometerReading
    ) {
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
        this.recordedAt = new Timestamp(System.currentTimeMillis());
    }

    

    public Long getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Garage getGarage() {
        return garage;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public Integer getOdometerReading() {
        return odometerReading;
    }

   

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
