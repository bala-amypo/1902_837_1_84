package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    Optional<ServiceEntry> getServiceEntryById(Long id);

    List<ServiceEntry> getEntriesForVehicle(Vehicle vehicle);

    List<ServiceEntry> findByVerifiedAtBetween(LocalDate start, LocalDate end);
}
