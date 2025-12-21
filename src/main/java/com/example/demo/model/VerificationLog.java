package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "verification_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_entry_id", nullable = false)
    private ServiceEntry serviceEntry;

    @Column(nullable = false, updatable = false)
    private Timestamp verifiedAt;

    @Column(nullable = false)
    private Boolean verifiedBySystem = true;

    private String notes;

    @PrePersist
    protected void onCreate() {
        this.verifiedAt = new Timestamp(System.currentTimeMillis());
        if (this.verifiedBySystem == null) {
            this.verifiedBySystem = true;
        }
    }
}
