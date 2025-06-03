package com.EmergencyServcice.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Hospital {

   private Long id;


   private String name;

   private String address;
   private String city;
   private String type;
   private String speciality;

   private String password;


   private Boolean icuAvailable;


   private Boolean otAvailable;
}
