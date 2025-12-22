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

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByVehicleAndDateBetween(Long vehicleId, LocalDate startDate, LocalDate endDate);

    List<ServiceEntry> findByGarageAndOdometerReadingGreaterThanEqual(Long garageId, int minOdometer);
}
