package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.Configurations.currUser;
import com.FrontEnd.Web_InterFace.EntityManager.Users.*;
import com.FrontEnd.Web_InterFace.FeignServices.FeaturesService;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import com.FrontEnd.Web_InterFace.Service.DoctorService;
import com.FrontEnd.Web_InterFace.Service.PatientService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private UpdateScheduleDTO dto;

    public PatientDashBoard(UserClient userClient, Patient p, DoctorService doctorService, currUser currUser, PatientService patientService, UpdateScheduleDTO dto, FeaturesService featuresService) {
        this.userClient = userClient;
        this.p = p;
        this.doctorService = doctorService;
        this.currUser = currUser;
        this.patientService = patientService;
        this.dto = dto;
        this.featuresService = featuresService;
       this.meetingDetails= meetingDetails;
    }

    @Autowired
    private FeaturesService featuresService;




    @GetMapping("/profile")
    public ModelAndView pProfile(ModelAndView mv){
        log.info("Patient Profile Method Access");
        try{
            System.out.println(currUser.getMail());
            ResponseEntity<Patient> patient= userClient.getPatientProfile(currUser.getMail());
            System.out.println(patient.getBody());
            System.out.println(patient.getStatusCode());
            if(patient!=null){
                p=patient.getBody();
                List<Schedule> result= patientService.getPatientSchedules(p.getP_id());
                System.out.println(result.toString());
                mv.addObject("schedules",result);
                mv.setViewName("pDashboard");
                mv.addObject("patient",p);
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
                // System.out.println(doc);
                mv.addObject("doc", doc);
                mv.setViewName("BookAppointment");
            }
        }
        log.info("Doctor not found ");
        mv.setViewName("BookAppointment");
        mv.addObject("Error", "Doctor Not Found : Internal Error");
        return mv;
    }

    @PostMapping("/updateSchedule/{d_id}")
    public String updateSchedule(@ModelAttribute Schedule schedule, @PathVariable("d_id") Long d_id, HttpSession session) {
        // Step 1: Retrieve the current user's patient profile
        ResponseEntity<Patient> response = userClient.getPatientProfile(currUser.getMail());
        Patient patient = response.getBody();

        if (patient == null) {
            System.err.println("Failed to retrieve patient profile for user: " + currUser.getMail());
            return "error"; // Handle error appropriately
        }

        // Step 4: Update the schedule
        System.out.println("Updating schedule for doctor ID: " + d_id);


        dto.setDate(schedule.getSlotDate());
        dto.setDoctorid(d_id);
        dto.setSlottime(schedule.getSlotTime());
        dto.setDescription(schedule.getDescription());
        dto.setPatientid(patient.getP_id());
        int res= userClient.updateSchedule(dto);

        return "redirect:/ZoomNotice";
    }

    @GetMapping("/shareMeetingDetails")
    public String shareMeetign(){
        System.out.println("Sharing Meeting details");
        System.out.println(meetingDetails.toString());
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
