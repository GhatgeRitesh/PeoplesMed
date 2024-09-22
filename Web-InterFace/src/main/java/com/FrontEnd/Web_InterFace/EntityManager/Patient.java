package com.FrontEnd.Web_InterFace.EntityManager;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("session")
@Getter @Setter
public class Patient {
    private Long patId;
    private String name;
    private String gender;
    private int age;
    private String contact;
    private String email;
    private String address;
    private String state;
    private String city;
    private String pincode;
    private Doctor doctor;
    private List<Prescription> prescriptions;
    private List<MedicalHistory> medicalHistories;
    private List<Consultation> consultations;
}
