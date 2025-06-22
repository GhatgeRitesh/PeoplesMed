package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "emergency_patient_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emergency_Requests {

    @Id
    @Column(name = "request_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "patient_condition")
    private String condition;

    private String address;

    private String contact;

    private Integer age;
    @Column(nullable = false)
    private String city;

    @Column(name = "ambulance_need")
    private Boolean ambulanceNeed;

    @Column(name = "emergency_type")
    private String emergencyType;

    @Column(name = "acceptance_status")
    private String acceptanceStatus;

    @Column(name= "time")
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "h_id")
    private Hospital hospital;
}
