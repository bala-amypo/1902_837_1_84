package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // CREATE service entry
    @PostMapping
    public ResponseEntity<ServiceEntry> createServiceEntry(
            @RequestBody ServiceEntry serviceEntry) {

        ServiceEntry created = serviceEntryService.createServiceEntry(serviceEntry);
        return ResponseEntity.ok(created);
    }

    // GET all service entries
    @GetMapping
    public ResponseEntity<List<ServiceEntry>> getAllServiceEntries() {
        return ResponseEntity.ok(serviceEntryService.getAllServiceEntries());
    }

    // GET service entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntry> getServiceEntryById(@PathVariable Long id) {
        ServiceEntry serviceEntry = serviceEntryService.getServiceEntryById(id);
        return ResponseEntity.ok(serviceEntry);
    }

    // GET service entries by vehicle ID
    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<ServiceEntry>> getEntriesByVehicle(
            @PathVariable long vehicleId) {

        return ResponseEntity.ok(
                serviceEntryService.getEntriesForVehicle(vehicleId)
        );
    }

    // UPDATE service entry
    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntry> updateServiceEntry(
            @PathVariable Long id,
            @RequestBody ServiceEntry serviceEntry) {

        ServiceEntry updated =
                serviceEntryService.updateServiceEntry(id, serviceEntry);

        return ResponseEntity.ok(updated);
    }

    // DELETE service entry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceEntry(@PathVariable Long id) {
        serviceEntryService.deleteServiceEntry(id);
        return ResponseEntity.noContent().build();
    }
}
