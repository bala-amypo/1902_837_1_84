package com.example.demo.repository;

import com.example.demo.model.VerificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;


@Repository
public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {
}
