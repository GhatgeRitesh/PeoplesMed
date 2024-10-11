package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("session")
@Getter @Setter
public class Prescription {
    private Long presId;
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private String issue;
    private String dosage;
    private String instructions;
    private String medicines;
}
