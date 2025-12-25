package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    Optional<ServiceEntry> findById(Long id);
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle v);
    List<ServiceEntry> findByVehicleId(Long vehicleId);
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int min);
    List<ServiceEntry> findByVehicleAndDateRange(Long id, LocalDate from, LocalDate to);
    ServiceEntry save(ServiceEntry e);
}
