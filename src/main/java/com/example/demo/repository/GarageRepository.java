package com.example.demo.repository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Garage;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Repository
public interface GarageRepository {
    Optional<Garage> findById(Long id);
    Optional<Garage> findByGarageName(String name);
    Garage save(Garage g);
}
