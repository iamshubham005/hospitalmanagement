package com.hospitalmanagement.hospitalmanagement.controller;

import com.hospitalmanagement.hospitalmanagement.dto.PatientDTO;
import com.hospitalmanagement.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/addpatient")
    public PatientDTO createPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    }

    @GetMapping("/listallpatient")
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/getpatientbyid/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PutMapping("/updatepatient/{id}")
    public PatientDTO updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        return patientService.updatePatient(id, patientDTO);
    }

    @DeleteMapping("/deletepatient/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "patient deleted successfully!";
    }

}