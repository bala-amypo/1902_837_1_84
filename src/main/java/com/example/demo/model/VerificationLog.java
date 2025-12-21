package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_logs")
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "service_entry_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_verification_service_entry")
    )
    private ServiceEntry serviceEntry;

    @Column(nullable = false, updatable = false)
    private LocalDateTime verifiedAt;

    public VerificationLog() {}

    public VerificationLog(ServiceEntry serviceEntry) {
        this.serviceEntry = serviceEntry;
        this.verifiedAt = LocalDateTime.now();
    }

    // Getters & Setters
}
