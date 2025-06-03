package com.EmergencyServcice.Model;

import lombok.Data;

@Data
public class HospitalStatusDTO {
    private String name;
    private String address;
    private String city;
    private String type;
    private String speciality;
    private String contact;
    private boolean ICU_Availability;
    private boolean OT_Active;
    private boolean status;
    private String PresentDoctor;
    private int staffCount;
    private int ambulanceCount;
}
