package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import com.FrontEnd.Web_InterFace.EntityManager.Users.UpdateScheduleDTO;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import com.FrontEnd.Web_InterFace.Configurations.currUser;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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


    public ScheduleController(com.FrontEnd.Web_InterFace.Service.scheduleService scheduleService, UserClient userClient, com.FrontEnd.Web_InterFace.Configurations.currUser currUser) {
        this.scheduleService = scheduleService;
        this.userClient = userClient;
        this.currUser = currUser;

    }




    @GetMapping("/getSchedules/{dId}")
    public List<Schedule> geSchedules(@PathVariable("dId") Long dId ,@RequestParam String date)
    {
        log.info("Method Access success");
        List<Schedule> result =scheduleService.getSchedules(dId,date);
        if(result.isEmpty()){
            Schedule schedule1 = new Schedule();
            schedule1.setSlotTime("09:00AM");
            schedule1.setLimit(0);
            schedule1.setDId(dId);
            schedule1.setSlotDate(date);
            userClient.saveSchedule(schedule1);

            Schedule schedule2 = new Schedule();
            schedule2.setSlotTime("10:00AM");
            schedule2.setLimit(0);
            schedule2.setDId(dId);
            schedule2.setSlotDate(date);
            userClient.saveSchedule(schedule2);

            Schedule schedule3 = new Schedule();
            schedule3.setSlotTime("11:00AM");
            schedule3.setLimit(0);
            schedule3.setDId(dId);
            schedule3.setSlotDate(date);
            userClient.saveSchedule(schedule3);

            Schedule schedule4 = new Schedule();
            schedule4.setSlotTime("12:00PM");
            schedule4.setLimit(0);
            schedule4.setDId(dId);
            schedule4.setSlotDate(date);
            userClient.saveSchedule(schedule4);

            Schedule schedule5 = new Schedule();
            schedule5.setSlotTime("02:00PM");
            schedule5.setLimit(0);
            schedule5.setDId(dId);
            schedule5.setSlotDate(date);
            userClient.saveSchedule(schedule5);

            Schedule schedule6 = new Schedule();
            schedule6.setSlotTime("03:00PM");
            schedule6.setLimit(0);
            schedule6.setDId(dId);
            schedule6.setSlotDate(date);
            userClient.saveSchedule(schedule6);

            return scheduleService.getSchedules(dId,date);
        }
        return result;
    }


}