package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/p")
@Log
public class ScheduleController {
    @Autowired
    private UserClient userClient;
    private Schedule schedule;
    public ScheduleController(Schedule schedule){this.schedule=schedule;}

    @PostMapping("/Schedule")
    public ResponseEntity<?> getSchedule(@ModelAttribute Schedule sch){
        log.info("Schedule controller Access");
        if(sch == null){
            log.info("Body Received Emoty");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        System.out.println(sch.toString());
        ResponseEntity<?> response=userClient.setSchedule(sch);
        if(response.getStatusCode().is5xxServerError()){
            log.info("Internal Server Error Form DB servicee");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
