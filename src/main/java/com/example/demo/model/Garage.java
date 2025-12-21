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

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(
        mappedBy = "garage",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<ServiceEntry> serviceEntries;

    public Garage() {}

    public Garage(String garageName, String address, Boolean active) {
        this.garageName = garageName;
        this.address = address;
        this.active = active;
    }

    // Getters & Setters
    public String getGarageName() { return garageName; }

public String getAddress() { return address; }

public String getContactNumber() { return contactNumber; }

public Boolean getActive() { return active; }

public void setActive(Boolean active) { this.active = active; }

}
