package com.HospitalService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class EmergencyRequestDTO {
    private Long id;
    private String name;
    private String condition;
    private String address;
    private String contact;
    private Integer age;
    private String city;
    private Boolean ambulanceNeed;
    private String emergencyType;
    private String acceptanceStatus;
    private Timestamp timestamp;
}
