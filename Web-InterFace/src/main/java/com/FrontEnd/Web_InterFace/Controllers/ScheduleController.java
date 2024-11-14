package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import com.FrontEnd.Web_InterFace.Service.DoctorService;
import com.FrontEnd.Web_InterFace.Service.ScheduleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@Log
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private Patient patient;

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private UserClient userClient;

     @PostMapping("/P/saveSchedule")
     public ModelAndView saveSchedule(@ModelAttribute Schedule schedule, ModelAndView mv){
         System.out.println(patient.getPatId());
         System.out.println(schedule.toString());
         userClient.saveSchedules(schedule);
       log.info(schedule.toString());

        return mv;
     }

     @GetMapping("/getSchedules/{doctorId}")
     public ModelAndView getSchedules(ModelAndView mv, @PathVariable Long doctorId, @RequestParam("date") String date){
         try {
             log.info("Entered into Controller" + doctorId+ " "+ date );
            List<Schedule> schedules= scheduleService.getSchedules(doctorId,date);
             System.out.println(schedules.toString());
            mv.addObject("schedules",schedules);
            mv.setViewName("profile");
            return mv;
         }catch (Exception e){
             mv.addObject("error", e);
             mv.setViewName("profile");
             return mv;
         }
     }

//    @PostMapping("/Schedule")
//    public ResponseEntity<?> getSchedule(@ModelAttribute Schedule sch){
//        log.info("Schedule controller Access");
//        if(sch == null){
//            log.info("Body Received Emoty");
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//        System.out.println(sch.toString());
//        ResponseEntity<?> response=userClient.setSchedule(sch);
//        if(response.getStatusCode().is5xxServerError()){
//            log.info("Internal Server Error Form DB servicee");
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{date}")
//    public ResponseEntity<List<Schedule>> getSchedulesByDate(@PathVariable String date) {
//        System.out.println("date : "+date);
//        List<Schedule> schedules = service.getSchedulesByDate(date);
//        for(Schedule doc : schedules) System.out.println(doc.getSlotTime());
//        if(schedules.size() == 0) {
//            Schedule docSchedule1 = new DocSchedule();
//            docSchedule1.setSlotDate(date);
//            docSchedule1.setSlotTime("09:00");
//            docSchedule1.setStatus(Status.AVAILABLE);
//
//            Schedule docSchedule2 = new DocSchedule();
//            docSchedule2.setSlotDate(date);
//            docSchedule2.setSlotTime("10:00");
//            docSchedule2.setStatus(Status.AVAILABLE);
//
//            Schedule docSchedule3 = new DocSchedule();
//            docSchedule3.setSlotDate(date);
//            docSchedule3.setSlotTime("11:00");
//            docSchedule3.setStatus(Status.AVAILABLE);
//
//            Schedule docSchedule4 = new DocSchedule();
//            docSchedule4.setSlotDate(date);
//            docSchedule4.setSlotTime("12:00");
//            docSchedule4.setStatus(Status.AVAILABLE);
//
//            Schedule docSchedule5 = new DocSchedule();
//            docSchedule5.setSlotDate(date);
//            docSchedule5.setSlotTime("01:00");
//            docSchedule5.setStatus(Status.AVAILABLE);
//
//            Schedule docSchedule6 = new DocSchedule();
//            docSchedule6.setSlotDate(date);
//            docSchedule6.setSlotTime("02:00");
//            docSchedule6.setStatus(Status.AVAILABLE);
//
//            Schedule.insertSlots(docSchedule1);
//            Schedule.insertSlots(docSchedule2);
//            Schedule.insertSlots(docSchedule3);
//            Schedule.insertSlots(docSchedule4);
//            Schedule.insertSlots(docSchedule5);
//            Schedule.insertSlots(docSchedule6);
//
//            schedules = service.getSchedulesByDate(date);
//        }
//        System.out.println(schedules.size());
//        return ResponseEntity.ok(schedules);
//    }
}
