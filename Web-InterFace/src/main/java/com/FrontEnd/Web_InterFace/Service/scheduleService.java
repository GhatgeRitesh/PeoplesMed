package com.FrontEnd.Web_InterFace.Service;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class scheduleService {

    @Autowired
    private UserClient userClient;
    public List<Schedule> getSchedules(Long dId , String Date){
       ResponseEntity<List<Schedule>> result = userClient.getSchedules(dId,Date);

       if(result.getStatusCode().is2xxSuccessful()) return result.getBody();
       else {
           System.out.println("The Error Status is :- " + result.getStatusCode());
           return null;
       }
    }
}
