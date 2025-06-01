package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "Hospital")
public class Hospital {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String name;
   private String address;
   private String type;
   private String speciality;
   private Boolean icuAvailable;
   private Integer staffCount;
   private Boolean openStatus;

   @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
   private List<Doctor> doctors;

   @OneToOne(mappedBy = "hospital", cascade = CascadeType.ALL)
   private HospitalResource hospitalResource;
}
