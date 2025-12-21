package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "service_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "garage_id", nullable = false)
    private Garage garage;

    @Column(nullable = false)
    private String serviceType;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date serviceDate;

    @Column(nullable = false)
    private Integer odometerReading;

    private String description;

    @Column(nullable = false, updatable = false)
    private Timestamp recordedAt;

    @PrePersist
    protected void onCreate() {
        this.recordedAt = new Timestamp(System.currentTimeMillis());
    }
}
