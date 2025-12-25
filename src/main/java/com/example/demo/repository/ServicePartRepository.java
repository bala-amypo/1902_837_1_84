package com.example.demo.repository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ServicePart;
@Repository
public interface ServicePartRepository {
    ServicePart save(ServicePart p);
}
