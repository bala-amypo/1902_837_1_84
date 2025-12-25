package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ServiceEntry serviceEntry;

    private LocalDateTime verifiedAt;

    // No-args constructor (REQUIRED)
    public VerificationLog() {}

    // All-args constructor (optional)
    public VerificationLog(Long id, ServiceEntry serviceEntry, LocalDateTime verifiedAt) {
        this.id = id;
        this.serviceEntry = serviceEntry;
        this.verifiedAt = verifiedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }

    public LocalDateTime getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(LocalDateTime verifiedAt) { this.verifiedAt = verifiedAt; }
}
