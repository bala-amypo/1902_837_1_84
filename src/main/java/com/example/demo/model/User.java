package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;   // ROLE_USER, ROLE_ADMIN, ROLE_GARAGE, etc.

    @Column(nullable = false)
    private Boolean active;

    // Mandatory no-arg constructor
    public User() {}

    // Parameterized constructor
    public User(String name, String email, String password, String role, Boolean active) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    // Getters and Setters
}
