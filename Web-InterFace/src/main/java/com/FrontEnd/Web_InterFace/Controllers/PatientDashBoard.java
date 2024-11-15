package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.Configurations.currUser;
import com.FrontEnd.Web_InterFace.EntityManager.Users.CacheData;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import com.FrontEnd.Web_InterFace.Service.DoctorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Objects;


@RequestMapping("/P")
@Controller
@Log4j2
public class PatientDashBoard {
    @Autowired
    private UserClient userClient;
    @Autowired
    private Patient p;

    @Autowired
    private DoctorService doctorService;

    private final currUser curruser;

    public PatientDashBoard(currUser curruser){this.curruser=curruser; }


    @GetMapping("/profile")
    public ModelAndView pProfile(ModelAndView mv){
        log.info("Patient Profile Method Access");
        try{
            System.out.println(curruser.getMail());
           ResponseEntity<Patient> patient= userClient.getPatientProfile(curruser.getMail());
            System.out.println(patient.getBody());
            System.out.println(patient.getStatusCode());
            if(patient!=null){
                p=patient.getBody();
                mv.setViewName("pDashboard");
                mv.addObject("Profile",patient);
            }
            else{
                System.out.println("Retrived Profile is null");
            }
        }catch(Exception e){
            log.info("Error While Feting User Data:- "+ e);
            mv.setViewName("pDashboard");
            mv.addObject("Profile","Error while fetching User profile");
            return mv;
        }
        return mv;
    }


    @GetMapping("/findDoctor")
    public ModelAndView PDashBoard(ModelAndView mv){
        log.info("This is Patient Id :- " + p.getP_id());
        log.info("docs list activated ");
            List<Doctor> list = doctorService.getCachedDocs();
           // System.out.println("List :- " + list.toString());
            mv.addObject("list", list);
            mv.setViewName("patientDashBoard");
            if(list.isEmpty()){
                log.info(" The list is Empty :");
                mv.addObject("list","The recieved list is empty :");
                mv.setViewName("FindDoctor");
            }
          //  System.out.println("List :- " + list.toString());
            mv.addObject("list", list);
            mv.setViewName("FindDoctor");

        return mv;
    }

    @GetMapping("/d/{d_id}")
    public ModelAndView DocProfile(@PathVariable("d_id") Long D_id, ModelAndView mv){
        log.info("DocProfile Activated");
        Doctor doc=null;
        for(Doctor d: doctorService.getCachedDocs()){
            if(Objects.equals(d.getD_id(), D_id)) {
                System.out.println("Doctor found");
                System.out.println(d);
                doc = d;
                System.out.println(doc);
                mv.addObject("doc", doc);
                mv.setViewName("BookAppointment");
            }
                log.info("Doctor not found ");
                mv.setViewName("BookAppointment");
                mv.addObject("Error", "Doctor Not Found : Internal Error");
                return mv;
        }
        log.info("Doctor not found ");
        mv.setViewName("BookAppointment");
        mv.addObject("Error", "Doctor Not Found : Internal Error");
        return mv;
    }
}

/*
*  find a doctor - controller will send list of doctors .
*  map the doctor description and co-ordinates into the doctor card
*  have the button to select the doctor
*  doctor profile should be displayed
*  doctor profile should be retrieved from database
*  doctor profile should contain the current doctor schedule
*
* can i save the doctor list as cache and then retrive from the list to use it in all the rest application
*
* */
