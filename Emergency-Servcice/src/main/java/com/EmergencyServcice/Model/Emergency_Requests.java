package com.EmergencyServcice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emergency_Requests {


    private Long id;


    private String name;


    private String condition;

    private String address;

    private String contact;

    private Integer age;


    private Boolean ambulanceNeed;


    private String emergencyType;


    private String acceptanceStatus;
}
