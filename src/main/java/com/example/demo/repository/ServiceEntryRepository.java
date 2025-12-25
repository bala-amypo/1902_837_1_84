package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // Spring Data JPA will create the query automatically
    List<ServiceEntry> findByVehicle(Vehicle vehicle);

    // Example: find entries between two dates
    List<ServiceEntry> findByServiceDateBetween(java.time.LocalDate startDate, java.time.LocalDate endDate);
}
