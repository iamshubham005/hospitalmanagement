package com.hospitalmanagement.hospitalmanagement.service;

import com.hospitalmanagement.hospitalmanagement.dto.PatientDTO;
import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(Long id);
    PatientDTO updatePatient(Long id, PatientDTO patientDTO);
    void deletePatient(Long id);
}
