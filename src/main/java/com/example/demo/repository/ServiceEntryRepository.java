package com.example.demo.repository;

import com.example.demo.model.*;
import java.time.LocalDate;
import java.util.*;
@Repository
public interface ServiceEntryRepository {
    Optional<ServiceEntry> findById(Long id);
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle v);
    List<ServiceEntry> findByVehicleId(Long vehicleId);
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int min);
    List<ServiceEntry> findByVehicleAndDateRange(Long id, LocalDate from, LocalDate to);
    ServiceEntry save(ServiceEntry e);
}
