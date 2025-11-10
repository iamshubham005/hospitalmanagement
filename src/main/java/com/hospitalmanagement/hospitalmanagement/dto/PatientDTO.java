package com.hospitalmanagement.hospitalmanagement.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private String address;
}
