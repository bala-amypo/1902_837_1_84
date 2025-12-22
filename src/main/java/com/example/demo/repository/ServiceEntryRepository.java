package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // 1️⃣ Latest service entry for a vehicle
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    // 2️⃣ All entries for a vehicle (by vehicle id)
    List<ServiceEntry> findByVehicleId(long vehicleId);

    // 3️⃣ Entries by garage and minimum odometer
    @Query("SELECT s FROM ServiceEntry s WHERE s.garage.id = :garageId AND s.odometerReading >= :minOdometer")
    List<ServiceEntry> findByGarageAndMinOdometer(
            @Param("garageId") long garageId,
            @Param("minOdometer") int minOdometer
    );

    // 4️⃣ Entries for a vehicle within date range
    @Query("SELECT s FROM ServiceEntry s WHERE s.vehicle.id = :vehicleId AND s.serviceDate BETWEEN :startDate AND :endDate")
    List<ServiceEntry> findByVehicleAndDateRange(
            @Param("vehicleId") long vehicleId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
