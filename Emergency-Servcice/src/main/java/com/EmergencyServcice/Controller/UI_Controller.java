package com.EmergencyServcice.Controller;

import com.EmergencyServcice.FeignClient.WebService;
import com.EmergencyServcice.Model.Patient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@Log
@RequestMapping("/EmergencyService")
public class UI_Controller {
    @Autowired
    private WebService webService;

    @GetMapping("/curr-city-hospitals")
    public ModelAndView emergencyPage(ModelAndView mv){
        log.info("Fetching patient details");
        Patient p =webService.getDetails().getBody();
        log.info("Getting Hospitals from city: "+p.getCity());
        return mv;
    }

    @GetMapping("/hospitalList")
    public ModelAndView getPage(ModelAndView mv) {
        log.info("Getting user details");
        Patient p =webService.getDetails().getBody();
        log.info("Current user : "+p);

        mv.addObject(p);
        mv.setViewName("interface");
        return mv;
    }
}

