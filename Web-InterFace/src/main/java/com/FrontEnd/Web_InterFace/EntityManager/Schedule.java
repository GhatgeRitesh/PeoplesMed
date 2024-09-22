package com.FrontEnd.Web_InterFace.EntityManager;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("session")
@Getter @Setter
public class Schedule {
    private Long schedId;
    private Doctor doctor;
    private Patient patient;
    private Date date;
}
