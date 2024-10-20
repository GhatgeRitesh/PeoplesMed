package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter @Setter
public class CacheData{
     private List<Doctor> DocList;
     private List<Patient> PatList;
     private List<Schedule> scheduleList;

     @Override
     public String toString() {
          return "CacheData{" +
                  "DocList=" + DocList +
                  ", PatList=" + PatList +
                  ", scheduleList=" + scheduleList +
                  '}';
     }
}
