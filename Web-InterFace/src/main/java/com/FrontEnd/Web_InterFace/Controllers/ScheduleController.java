package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.Configurations.currUser;
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

    @Autowired
    private currUser curruser;

    private  Long DoctorId;

     @PostMapping("/P/saveSchedule")
     public ModelAndView saveSchedule(@ModelAttribute Schedule schedule, ModelAndView mv){
         System.out.println(patient.getP_id());

         // patient id and name , email , reason / status


         System.out.println(schedule.toString());
         userClient.saveSchedules(schedule);
       log.info(schedule.toString());

        return mv;
     }

    @PostMapping("/P/updateSchedule")
    public String updateSchedule(@ModelAttribute Schedule schedule, ModelAndView mv){
        System.out.println("Controller Activated");
        System.out.println(patient.getP_id());
        System.out.println(schedule.toString());
        System.out.println(DoctorId);
        List<Schedule> schedules = scheduleService.getSchedules(DoctorId, schedule.getSlotDate());
        System.out.println(schedules.toString());
        for (Schedule schedule1 : schedules) {
            if (schedule1.getDoctorId().equals(schedule.getDoctorId()) &&
                    schedule1.getSlotTime().equals(schedule.getSlotTime()) &&
                    schedule1.getSlotDate().equals(schedule.getSlotDate())) {
                schedule.setCurrstatus(Schedule.Status.ALLOTTED);
                userClient.updateSchedule(schedule);
            }
        }

        //  userClient.saveSchedules(schedule);
        log.info(schedule.toString());

        return "Ok";
    }


     @GetMapping("/getSchedules/{doctorId}")
     public ResponseEntity<List<Schedule>> getSchedules(@PathVariable Long doctorId , @RequestParam("date") String date){
         try{
             log.info("Schedules Fetching started");
             System.out.println(date +" "+ doctorId);
             List<Schedule> schedules= scheduleService.getSchedules(doctorId,date);
             log.info("fetching success");
             DoctorId=doctorId;
             if(schedules.size() == 0){
                 Schedule docSchedule1 = new Schedule();
                docSchedule1.setSlotDate(date);
                docSchedule1.setSlotTime("09:00");
                docSchedule1.setCurrstatus(Schedule.Status.AVAILABLE);
                docSchedule1.setDoctorId(doctorId);


                Schedule docSchedule2 = new Schedule();
                docSchedule2.setSlotDate(date);
                docSchedule2.setSlotTime("10:00");
                docSchedule2.setCurrstatus(Schedule.Status.AVAILABLE);
                 docSchedule2.setDoctorId(doctorId);

                Schedule docSchedule3 = new Schedule();
                docSchedule3.setSlotDate(date);
                docSchedule3.setSlotTime("11:00");
                docSchedule3.setCurrstatus(Schedule.Status.AVAILABLE);
                 docSchedule3.setDoctorId(doctorId);

                Schedule docSchedule4 = new Schedule();
                docSchedule4.setSlotDate(date);
                docSchedule4.setSlotTime("12:00");
                docSchedule4.setCurrstatus(Schedule.Status.AVAILABLE);
                 docSchedule4.setDoctorId(doctorId);

                Schedule docSchedule5 = new Schedule();
                docSchedule5.setSlotDate(date);
                docSchedule5.setSlotTime("01:00");
                docSchedule5.setCurrstatus(Schedule.Status.AVAILABLE);
                 docSchedule5.setDoctorId(doctorId);

                Schedule docSchedule6 = new Schedule();
                docSchedule6.setSlotDate(date);
                docSchedule6.setSlotTime("02:00");
                docSchedule6.setCurrstatus(Schedule.Status.AVAILABLE);
                 docSchedule6.setDoctorId(doctorId);

                 userClient.saveSchedules(docSchedule1);
                 userClient.saveSchedules(docSchedule2);
                 userClient.saveSchedules(docSchedule3);
                 userClient.saveSchedules(docSchedule4);
                 userClient.saveSchedules(docSchedule5);
                 userClient.saveSchedules(docSchedule6);

                 schedules= scheduleService.getSchedules(doctorId,date);
                 return new ResponseEntity<>(schedules,HttpStatus.OK);
             }
             return new ResponseEntity<>(schedules,HttpStatus.OK);
         }catch (Exception e){
             log.info("Error While Fetching Schedules :- " + e);
             return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
         }

     }

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
