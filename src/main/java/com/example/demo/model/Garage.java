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

    private String address;
    private String contactNumber;

    @Column(nullable = false)
    private Boolean active = true;

    @OneToMany(mappedBy = "garage", fetch = FetchType.LAZY)
    private List<ServiceEntry> serviceEntries;

    public Garage() {}

    // GETTERS
    public Long getId() { return id; }
    public String getGarageName() { return garageName; }
    public String getAddress() { return address; }
    public String getContactNumber() { return contactNumber; }
    public Boolean getActive() { return active; }

    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setGarageName(String garageName) { this.garageName = garageName; }
    public void setAddress(String address) { this.address = address; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setActive(Boolean active) { this.active = active; }
}
