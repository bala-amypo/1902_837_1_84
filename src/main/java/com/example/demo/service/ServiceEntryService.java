package com.example.demo.service;

import com.example.demo.model.ServiceEntry;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry serviceEntry);

    List<ServiceEntry> getAllServiceEntries();

    Optional<ServiceEntry> getServiceEntryById(Long id);

    ServiceEntry updateServiceEntry(Long id, ServiceEntry serviceEntry);

    void deleteServiceEntry(Long id);
}
