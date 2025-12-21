package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "garages",
        uniqueConstraints = @UniqueConstraint(columnNames = "garageName")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
