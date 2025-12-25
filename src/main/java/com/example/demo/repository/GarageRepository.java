package com.example.demo.repository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Garage;
import java.util.Optional;
@Repository
public interface GarageRepository {
    Optional<Garage> findById(Long id);
    Optional<Garage> findByGarageName(String name);
    Garage save(Garage g);
}
