package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

   @PostMapping
public ResponseEntity<ServicePart> createServicePart(@RequestBody ServicePart part) {
    ServicePart savedPart = servicePartService.createServicePart(part);
    return ResponseEntity.ok(savedPart);
}


    @GetMapping
    public ResponseEntity<List<ServicePart>> getAllServiceParts() {
        return ResponseEntity.ok(servicePartService.getAllServiceParts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicePart> getServicePartById(@PathVariable Long id) {
        ServicePart part = servicePartService.getServicePartById(id)
                .orElseThrow(() -> new RuntimeException("Service Part not found with id: " + id));
        return ResponseEntity.ok(part);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicePart> updateServicePart(@PathVariable Long id, @RequestBody ServicePart updatedPart) {
        ServicePart part = servicePartService.updateServicePart(id, updatedPart);
        return ResponseEntity.ok(part);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicePart(@PathVariable Long id) {
        servicePartService.deleteServicePart(id);
        return ResponseEntity.noContent().build();
    }
}

