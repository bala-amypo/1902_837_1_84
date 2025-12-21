// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
//  @Table(name = "verification_logs")
// public class VerificationLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String message;
//     private LocalDateTime createdAt = LocalDateTime.now();

//     public VerificationLog() {}

//     public Long getId() {
//         return id;
//     }

//     public String getMessage() {
//         return message;
//     }

//     public LocalDateTime getCreatedAt() {
//         return createdAt;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setMessage(String message) {
//         this.message = message;
//     }

//     public void setCreatedAt(LocalDateTime createdAt) {
//         this.createdAt = createdAt;
//     }
