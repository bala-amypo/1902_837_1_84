package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String location;

    private boolean active = true; // <--- added field

    public Garage() {}

    public Garage(String name, String location) {
        this.name = name;
        this.location = location;
        this.active = true;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public boolean getActive() { return active; } // <--- getter
    public void setActive(boolean active) { this.active = active; } // <--- setter
}
