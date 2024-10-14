package com.FrontEnd.Web_InterFace.EntityManager.Users;

import com.fasterxml.jackson.databind.node.LongNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter @Setter
public class Schedule {
    private Long schedId;
    private Long doctor;
    private Long  patient;
    private Date date;
}
