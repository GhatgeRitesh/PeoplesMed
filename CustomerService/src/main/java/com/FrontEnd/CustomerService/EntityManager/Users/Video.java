package com.FrontEnd.CustomerService.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("session")
@Getter @Setter
public class Video {
    private Long vidId;
    private Consultation consultation;
    private Date date;
    private String link;
    private String status;
}