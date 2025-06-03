package com.HospitalService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalStatusDTO {
    private String name;
    private String address;
    private String city;
    private String type;
    private String speciality;
    private String contact;
    private Boolean icuAvailable;
    private Boolean otActive;
    private Boolean status;
    private String presentDoctor;
    private Integer staffCount;
    private Integer ambulanceCount;
}
