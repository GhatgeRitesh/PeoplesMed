package com.FrontEnd.Web_InterFace.EntityManager.Users;

import com.fasterxml.jackson.databind.node.LongNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Scope("prototype")
@Component
@Getter @Setter
public class Schedule {
     private Long doctorId;
     private  String name;
     private  String email;
     private  String reason;
     private Long patientId;
     private String slotDate;
     private String slotTime;
     private Status currstatus;

     public enum Status{
          AVAILABLE,ALLOTTED
     }

     @Override
     public String toString() {
          return "Schedule{" +
                  "doctorId=" + doctorId +
                  ", name='" + name + '\'' +
                  ", email='" + email + '\'' +
                  ", reason='" + reason + '\'' +
                  ", patientId=" + patientId +
                  ", slotDate='" + slotDate + '\'' +
                  ", slotTime='" + slotTime + '\'' +
                  ", currstatus=" + currstatus +
                  '}';
     }
}
