package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("session")
@Getter @Setter
public class MedicalHistory {
    private Long histId;
    private Patient patient;
    private Disease disease;
    private Date date;
    private String notes;
}
