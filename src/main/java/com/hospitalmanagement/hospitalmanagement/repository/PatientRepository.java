package com.hospitalmanagement.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospitalmanagement.hospitalmanagement.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
