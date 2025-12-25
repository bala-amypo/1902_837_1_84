package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageServiceImpl {

    @Autowired
    private GarageRepository garageRepository;

    public Garage createGarage(Garage g) {
        if (garageRepository.findByGarageName(g.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("Garage already exists");
        }
        return garageRepository.save(g);
    }
}
