package com.Database.PeoplesMedDB.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Doctor")
@Getter @Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Long docId;

    @Column(name = "password")
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "register_no", nullable = false, unique = true)
    private String registerNo;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "hospital_name", nullable = false)
    private String hospitalName;
    @Column(name = "address", nullable = false)
    private String address;

    @Override
    public String toString() {
        return "Doctor{" +
                "docId=" + docId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", registerNo='" + registerNo + '\'' +
                ", city='" + city + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }



}
