package com.EmergencyServcice.Controller;

import com.EmergencyServcice.FeignClient.Hospital_Service;
import com.EmergencyServcice.FeignClient.WebService;
import com.EmergencyServcice.Model.*;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Controller
@Log
@RequestMapping("/EmergencyService")
public class UI_Controller {

    @Autowired
    private WebService webService;


    @Autowired
    private Hospital_Service hospitalService;

    private Emergency_Requests emergencyRequestsVar;

    @Autowired
    private DataHolder dataHolder;

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
             emergencyRequestsVar=emergencyRequests;
            log.info("Requesting data from hospital service");
            ResponseEntity<List<HospitalStatusDTO>> hospital= hospitalService.getHospitals(emergencyRequests);
            dataHolder.setList(hospital.getBody());
            //log.info("Recieved Data is : "+ hospital.toString());
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
    public ModelAndView emergencyService(@RequestParam("hospitalId") Long hospitalId) {
        ModelAndView mv = new ModelAndView("Ifram"); // Replace with actual JSP view name
        mv.addObject("hospitalId", hospitalId);
        log.info("Emergency Request Data: "+ emergencyRequestsVar.toString());
        log.info("Got the Hospital ID: "+ hospitalId);
        UUID uuid = UUID.randomUUID();
        Long id= uuid.getLeastSignificantBits();
        emergencyRequestsVar.setId(id);
        log.info("Unique Request Id :"+ id);
        Hospital hospital= new Hospital();

        for(HospitalStatusDTO h: dataHolder.getList()){
            if(Objects.equals(h.getId(), hospitalId)){
                hospital.setId(hospitalId);
                hospital.setId(h.getId());
                hospital.setName(h.getName());
                hospital.setAddress(h.getAddress());
                hospital.setCity(h.getCity());
                hospital.setType(h.getType());
                hospital.setSpeciality(h.getSpeciality());
                hospital.setIcuAvailable(h.getIcuAvailable());
                hospital.setOtAvailable(h.getOtActive());

            }
        }
        emergencyRequestsVar.setHospital(hospital);
        dataHolder.setEmergencyRequestId(id);
        hospitalService.saveEmergencyRequest(emergencyRequestsVar);
        mv.addObject("request",emergencyRequestsVar);
        return mv;
    }
}

