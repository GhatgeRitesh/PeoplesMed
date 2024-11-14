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
     private Long doctorId;
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
                  "doctor_id=" + doctorId +
                  ", patient_id=" + patientId +
                  ", slotDate='" + slotDate + '\'' +
                  ", slotTime='" + slotTime + '\'' +
                  ", currstatus='" + currstatus + '\'' +
                  '}';
     }
}
