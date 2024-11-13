package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/P")
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

    @GetMapping("/{date}")
    public ResponseEntity<List<Schedule>> getSchedulesByDate(@PathVariable String date) {
        System.out.println("date : "+date);
        List<Schedule> schedules = service.getSchedulesByDate(date);
        for(Schedule doc : schedules) System.out.println(doc.getSlotTime());
        if(schedules.size() == 0) {
            Schedule docSchedule1 = new DocSchedule();
            docSchedule1.setSlotDate(date);
            docSchedule1.setSlotTime("09:00");
            docSchedule1.setStatus(Status.AVAILABLE);

            Schedule docSchedule2 = new DocSchedule();
            docSchedule2.setSlotDate(date);
            docSchedule2.setSlotTime("10:00");
            docSchedule2.setStatus(Status.AVAILABLE);

            Schedule docSchedule3 = new DocSchedule();
            docSchedule3.setSlotDate(date);
            docSchedule3.setSlotTime("11:00");
            docSchedule3.setStatus(Status.AVAILABLE);

            Schedule docSchedule4 = new DocSchedule();
            docSchedule4.setSlotDate(date);
            docSchedule4.setSlotTime("12:00");
            docSchedule4.setStatus(Status.AVAILABLE);

            Schedule docSchedule5 = new DocSchedule();
            docSchedule5.setSlotDate(date);
            docSchedule5.setSlotTime("01:00");
            docSchedule5.setStatus(Status.AVAILABLE);

            Schedule docSchedule6 = new DocSchedule();
            docSchedule6.setSlotDate(date);
            docSchedule6.setSlotTime("02:00");
            docSchedule6.setStatus(Status.AVAILABLE);

            Schedule.insertSlots(docSchedule1);
            Schedule.insertSlots(docSchedule2);
            Schedule.insertSlots(docSchedule3);
            Schedule.insertSlots(docSchedule4);
            Schedule.insertSlots(docSchedule5);
            Schedule.insertSlots(docSchedule6);

            schedules = service.getSchedulesByDate(date);
        }
        System.out.println(schedules.size());
        return ResponseEntity.ok(schedules);
    }
}
