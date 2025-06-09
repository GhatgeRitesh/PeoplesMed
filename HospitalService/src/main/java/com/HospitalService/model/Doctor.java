package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Data
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String speciality;

    private String contact;

    private String degree;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "h_id")
    private Hospital hospital;
}
