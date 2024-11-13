package com.FrontEnd.Web_InterFace.Service;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ScheduleService {
    @Autowired
    private UserClient userClient;

    @Cacheable(value = "scheduleCache" ,key = "'allSchedules'")
    public ResponseEntity<Schedule> getSchedules(Long doc_id,String date){
        try{
            ResponseEntity<Schedule> schedules= userClient.getSchedule(doc_id,date);
            return schedules;
        }catch(Exception e){
            log.info("Unable retrive Schedules :->" + e);
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
