package com.example.demo.repository;

import com.example.demo.model.*;
import java.time.LocalDate;
import java.util.*;
@Repository
public interface VehicleRepository {
    Optional<Vehicle> findById(Long id);
    Optional<Vehicle> findByVin(String vin);
    List<Vehicle> findByOwnerId(Long ownerId);
    Vehicle save(Vehicle v);
    void deleteById(Long id);
}
