package com.EmergencyServcice.Model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class HospitalStatusDTO {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String type;
    private String speciality;
    private String contact;
    private Boolean icuAvailable;
    private Boolean otActive;
    private Boolean status_1;
    private String presentDoctor;
    private Integer staffCount;
    private Integer ambulanceCount;
}
