package com.HospitalService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;
import java.util.List;

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
   private String city;
   private String type;
   private String speciality;
   @Column(name="password" , nullable = false)
   private String password;

   @Column(name = "icu_available")
   private Boolean icuAvailable;

   @Column(name = "ot_available")
   private Boolean otAvailable;
}
