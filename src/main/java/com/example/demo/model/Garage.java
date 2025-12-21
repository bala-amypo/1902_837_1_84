package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
    name = "garages",
    uniqueConstraints = @UniqueConstraint(columnNames = "garageName")
)
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String garageName;

    @Column(nullable = false)
    private String address;

    @Column
    private String contactNumber;

    @Column(nullable = false)
    private Boolean active = true;

    @OneToMany(
        mappedBy = "garage",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<ServiceEntry> serviceEntries;

    public Garage() {}

    public Garage(String garageName, String address, String contactNumber) {
        this.garageName = garageName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.active = true;
    }

    /* ================= GETTERS ================= */

    public Long getId() {
        return id;
    }

    public String getGarageName() {
        return garageName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public Boolean getActive() {
        return active;
    }

    /* ================= SETTERS ================= */

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
