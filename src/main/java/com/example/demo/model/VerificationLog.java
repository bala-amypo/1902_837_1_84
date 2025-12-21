package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "verification_logs")
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_entry_id", nullable = false)
    private ServiceEntry serviceEntry;

    private Timestamp verifiedAt = new Timestamp(System.currentTimeMillis());
    private Boolean verifiedBySystem = true;
    private String notes;

    public VerificationLog() {}

    // GETTERS
    public Long getId() { return id; }
    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public Timestamp getVerifiedAt() { return verifiedAt; }
    public Boolean getVerifiedBySystem() { return verifiedBySystem; }
    public String getNotes() { return notes; }

    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }
    public void setVerifiedAt(Timestamp verifiedAt) { this.verifiedAt = verifiedAt; }
    public void setVerifiedBySystem(Boolean verifiedBySystem) { this.verifiedBySystem = verifiedBySystem; }
    public void setNotes(String notes) { this.notes = notes; }
}
