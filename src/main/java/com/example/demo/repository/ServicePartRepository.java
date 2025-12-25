package com.example.demo.repository;

import com.example.demo.model.ServicePart;
@Repository
public interface ServicePartRepository {
    ServicePart save(ServicePart p);
}
