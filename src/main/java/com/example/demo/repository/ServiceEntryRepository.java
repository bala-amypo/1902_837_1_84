package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    @Query("select s from ServiceEntry s where s.garage.id = :garageId and s.odometerReading > :min")
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int min);

    @Query("select s from ServiceEntry s where s.vehicle.id = :vid and s.serviceDate between :from and :to")
    List<ServiceEntry> findByVehicleAndDateRange(Long vid, LocalDate from, LocalDate to);
}
