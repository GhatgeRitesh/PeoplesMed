package com.Database.PeoplesMedDB.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Doctor")
@Getter @Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "D_id")
    private Integer D_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "register_no", nullable = false, unique = true)
    private String registerNo;

    @Column(name = "education", nullable = false)
    private String education;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "experience", nullable = false)
    private String experience;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "hospital_name", nullable = false)
    private String hospitalName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Override
    public String toString() {
        return "Doctor{" +
                "D_id=" + D_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact=" + contact +
                ", registerNo='" + registerNo + '\'' +
                ", education='" + education + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience='" + experience + '\'' +
                ", city='" + city + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
