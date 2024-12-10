package com.FrontEnd.CustomerService.Controllers;

import com.FrontEnd.CustomerService.EntityManager.Users.Appointments;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
@RequestMapping("/P")
public class AppointmentsController {
    @Autowired
    private Appointments appointments;

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/getSchedules/{d_id}")
    public List<Appointments> getAppointments(@PathVariable Long d_id, @RequestParam String date){
        log.info("Web - fetching - appointments ");
        List<Appointments> result = databaseService.getAschedule(d_id,date);
        log.info("web - fetching - appointments - completed");
        return result;
    }
}
