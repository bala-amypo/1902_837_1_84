package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
@Tag(name = "Garage CRUD")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public Garage createGarage(@RequestBody Garage garage) {
        return garageService.createGarage(garage);
    }

    @GetMapping
    public List<Garage> getAllGarages() {
        return garageService.getAllGarages();
    }

    @GetMapping("/{id}")
    public Garage getGarageById(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    @PutMapping("/{id}")
    public Garage updateGarage(@PathVariable Long id,
                               @RequestBody Garage garage) {
        return garageService.updateGarage(id, garage);
    }

    @DeleteMapping("/{id}")
    public void deleteGarage(@PathVariable Long id) {
        garageService.deleteGarage(id);
    }
}
