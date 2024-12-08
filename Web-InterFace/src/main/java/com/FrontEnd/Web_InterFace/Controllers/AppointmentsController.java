package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Appointments;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log
@RequestMapping("/P")
public class AppointmentsController {
    @Autowired
    private Appointments appointments;

    @Autowired
    private UserClient userClient;

    @GetMapping("/getSchedules/{d_id}")
    public List<Appointments> getAppointments(@PathVariable Long d_id, @RequestParam String date){
        log.info("Web - fetching - appointments ");
        List<Appointments> result = userClient.getAschedule(d_id,date);
        log.info("web - fetching - appointments - completed");
        return new ArrayList<>();
    }
}
