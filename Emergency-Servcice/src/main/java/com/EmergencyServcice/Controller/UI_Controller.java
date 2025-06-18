package com.EmergencyServcice.Controller;

import com.EmergencyServcice.FeignClient.Hospital_Service;
import com.EmergencyServcice.FeignClient.WebService;
import com.EmergencyServcice.Model.Emergency_Requests;
import com.EmergencyServcice.Model.HospitalStatusDTO;

import com.EmergencyServcice.Model.Patient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@Log
@RequestMapping("/EmergencyService")
public class UI_Controller {

    @Autowired
    private WebService webService;


    @Autowired
    private Hospital_Service hospitalService;


    @GetMapping("/curr-city-hospitals")
    public ModelAndView emergencyPage(ModelAndView mv) {
        log.info("Fetching patient details");
        Patient p = webService.getDetails().getBody();
        log.info("Getting Hospitals from city: " + p.getCity());
        return mv;

    }

    @GetMapping("/form")
    public ModelAndView getform(ModelAndView mv){
        log.info("Emergency form requested");
        log.info("Getting user details");
        try{
            Patient p = webService.getDetails().getBody();
            log.info("Details fetched successfully as:- "+p);
            mv.setViewName("EmergencyForm");
            mv.addObject("patient", p);
            return mv;
        }catch(Exception e){

            log.info("Exception encountered while fetching Emergency form: "+ e.getMessage());

            log.info("Exception encountered while fetching Emergency form");

            mv.setViewName("Error");
            mv.addObject("Error","Internal Server Error");
            return mv;
        }

    }

    @PostMapping("/submitEmergency")
    public ModelAndView getform(@ModelAttribute Emergency_Requests emergencyRequests, ModelAndView mv){
        log.info("form received");
        try {
            if (emergencyRequests == null) {
                throw new RuntimeException("Form received empty");
            }
            log.info("form data as:- "+ emergencyRequests.toString());

            log.info("Requesting data from hospital service");
            ResponseEntity<List<HospitalStatusDTO>> hospital= hospitalService.getHospitals(emergencyRequests);
            log.info("Recieved Data is : "+ hospital.toString());
            if(!hospital.getStatusCode().is2xxSuccessful()){throw new RuntimeException("Internal Server Error");}
            mv.addObject("hospitals",hospital.getBody());
            mv.setViewName("DashBoard");



            return mv;
        }catch(Exception e){
            log.info("Exception while working with form: "+ e.getMessage());
            mv.addObject("error",e.getMessage());
            mv.setViewName("Error");
            return mv;
        }

    }

    @GetMapping("/Ifram")
    public  ModelAndView  EmergencyService(ModelAndView MV){

    }

}

