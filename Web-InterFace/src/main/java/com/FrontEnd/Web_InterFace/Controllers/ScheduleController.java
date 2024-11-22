package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import com.FrontEnd.Web_InterFace.Configurations.currUser;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.FrontEnd.Web_InterFace.Service.scheduleService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@RestController
@Log
public class ScheduleController{

    @Autowired
    private scheduleService scheduleService;

    @Autowired
    private UserClient userClient;

    @Autowired
    private currUser currUser;

    public ScheduleController(currUser currUser) {
        this.currUser = currUser;
    }

    @GetMapping("/getSchedules/{dId}")
    public List<Schedule> geSchedules(@PathVariable("dId") Long dId ,@RequestParam String date)
    {
        log.info("Method Access success");
        List<Schedule> result =scheduleService.getSchedules(dId,date);
        System.out.println(result.size());
        System.out.println(result.toString());
        return result;
    }

    @PostMapping("/P/updateSchedule/{d_id}")
    public ModelAndView saveSchedule(@ModelAttribute Schedule schedule ,@PathVariable("d_id") Long d_id,ModelAndView mv){
        log.info("Saving Schedule");
        try{
            ResponseEntity<Patient> p= userClient.getPatientProfile(currUser.getMail());
            schedule.setDId(d_id);
            schedule.setPId(Objects.requireNonNull(p.getBody()).getP_id());
            System.out.println(schedule.getDescription());
            userClient.saveSchedule(schedule);
            log.info("schedule saved successfully");
            mv.setViewName("profile");
            return mv;
        }catch(Exception e){
            log.info("Error Occurred while saving  terminating process :-  " + e);
            mv.addObject("errorcode",500);
            mv.setViewName("error");
            return mv;
        }
    }

}