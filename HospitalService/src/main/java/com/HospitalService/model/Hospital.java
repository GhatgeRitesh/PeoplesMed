package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter @Setter
@Table(name = "Hospital")
public class Hospital {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "h_id")
   private Long id;

   @Column(nullable = false)
   private String name;

   private String address;
   @Column(nullable = false)
   private String city;
   private String type;
   private String speciality;
   @Column(name="password" , nullable = false)
   private String password;
   private String contact;

   @Column(name = "icu_available")
   private Boolean icuAvailable;

   @Column(name = "ot_available")
   private Boolean otAvailable;
}
