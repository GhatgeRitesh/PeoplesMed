package com.FrontEnd.Web_InterFace.EntityManager;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Getter @Setter
public class Doctor {
    private Long docId;
    private String name;
    private String specialization;
    private String city;
    private String contact;
    private String email;
    private String degree;
    private String patients;
    private List<Prescription> prescriptions;
    private List<Schedule> schedules;

    @Override
    public String toString() {
        return "Doctor{" +
                "docId=" + docId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", city='" + city + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", degree='" + degree + '\'' +
                ", patients='" + patients + '\'' +
                ", prescriptions=" + prescriptions +
                ", schedules=" + schedules +
                '}';
    }
}
