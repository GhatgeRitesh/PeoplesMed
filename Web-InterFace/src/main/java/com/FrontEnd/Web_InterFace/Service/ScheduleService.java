package com.FrontEnd.Web_InterFace.Service;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ScheduleService {
    @Autowired
    private UserClient userClient;

    @Cacheable
    public List<Schedule> getSchedules(Long doctorId, String date){
        try{
            log.info("Entered into schedule Service");
            List<Schedule> schedules= userClient.getSchedules(doctorId,date).getBody();
            System.out.println(schedules.toString());
            log.info("schedule Service success");
            return schedules;
        }catch (Exception e){
            return null;
        }
    }
}
