package com.Database.PeoplesMedDB.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Getter @Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id; // Primary Key

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "age" )
    private int age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "password")
    private String password;

    @Column(name = "role" , nullable = false)
    private String role;

    @Override
    public String toString() {
        return "Patient{" +
                "pId=" + p_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}