package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "garage")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String garageName;

    private String address;
    private String contactNumber;

    public Garage() {}

    public Garage(Long id, String garageName, String address, String contactNumber) {
        this.id = id;
        this.garageName = garageName;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGarageName() { return garageName; }
    public void setGarageName(String garageName) { this.garageName = garageName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}
