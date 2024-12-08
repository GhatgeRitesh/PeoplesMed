package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.Configurations.currUser;
import com.FrontEnd.Web_InterFace.EntityManager.Mail.MeetingDetails;
import com.FrontEnd.Web_InterFace.EntityManager.Users.*;
import com.FrontEnd.Web_InterFace.FeignServices.FeaturesService;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import com.FrontEnd.Web_InterFace.Service.DoctorService;
import com.FrontEnd.Web_InterFace.Service.PatientService;
import com.FrontEnd.Web_InterFace.Configurations.currDoctor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private currUser currUser;

    @Autowired
    private MeetingDetails meetingDetails;

    @Autowired
    private PatientService patientService;

    @Autowired
    private FeaturesService featuresService;

    @Autowired
    private currDoctor currDoctor;


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
                // System.out.println(doc);
                mv.addObject("doc", doc);
                mv.setViewName("BookAppointment");
                currDoctor.setDoctorEmail(d.getEmail());
                currDoctor.setDoctorName(d.getName());
                currDoctor.setDoctorId(d.getD_id());
                return mv;
            }
        }
        log.info("Doctor not found ");
        mv.setViewName("BookAppointment");
        mv.addObject("Error", "Doctor Not Found : Internal Error");
        return mv;
    }


 //redirect url for zoom notice return "redirect:/ZoomNotice";
    @GetMapping("/shareMeetingDetails")
    public String shareMeetign(){
        return "redirect:/login/profile";
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
