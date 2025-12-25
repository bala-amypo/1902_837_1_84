package com.example.demo.repository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ServicePart;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Repository
public interface ServicePartRepository {
    ServicePart save(ServicePart p);
}
