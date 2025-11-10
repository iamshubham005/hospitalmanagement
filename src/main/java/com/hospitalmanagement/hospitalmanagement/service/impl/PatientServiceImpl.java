package com.hospitalmanagement.hospitalmanagement.service.impl;

import com.hospitalmanagement.hospitalmanagement.dto.PatientDTO;
import com.hospitalmanagement.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.hospitalmanagement.repository.PatientRepository;
import com.hospitalmanagement.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private PatientDTO convertToDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setAge(patient.getAge());
        dto.setGender(patient.getGender());
        dto.setContactNumber(patient.getContactNumber());
        dto.setAddress(patient.getAddress());
        return dto;
    }

    private Patient convertToEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setId(dto.getId());
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setContactNumber(dto.getContactNumber());
        patient.setAddress(dto.getAddress());
        return patient;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = convertToEntity(patientDTO);
        return convertToDTO(patientRepository.save(patient));
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        existing.setName(patientDTO.getName());
        existing.setAge(patientDTO.getAge());
        existing.setGender(patientDTO.getGender());
        existing.setContactNumber(patientDTO.getContactNumber());
        existing.setAddress(patientDTO.getAddress());
        return convertToDTO(patientRepository.save(existing));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
