package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import com.FrontEnd.Web_InterFace.Service.DoctorService;
import com.FrontEnd.Web_InterFace.Service.PatientService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.FrontEnd.Web_InterFace.Configurations.currUser;
import com.FrontEnd.Web_InterFace.Service.scheduleService;

import java.util.List;


@Controller
@RequestMapping("/login")
@Log
public class LoginController {

    @Autowired
    private currUser curruser;

    @Autowired
    private UserClient userClient;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private Patient p;

    @Autowired
    private Doctor d;

    @Autowired
    private scheduleService scheduleservice;

    public LoginController(currUser curruser){
        this.curruser=curruser;
    }

    @GetMapping()
    public ModelAndView loginform(ModelAndView mv){
        log.info("Login Form Access");
        mv.setViewName("PLogin");
        return mv;
    }
    @GetMapping("/Failure")
    public ModelAndView failure(ModelAndView mv){
        mv.setViewName("loginFailure");
        return mv;
    }

    @GetMapping("/profile")
    public ModelAndView pProfile(ModelAndView mv) {
        log.info("Fetching User Data");
        if (curruser.getRole().equals("[ROLE_PATIENT]")) {
            ResponseEntity<Patient> patient = userClient.getPatientProfile(curruser.getMail());
            if (patient != null) {
                p = patient.getBody();
                curruser.setName(p.getName());
                mv.setViewName("pDashboard");
                mv.addObject("patient", p);
                log.info("Diverting to user DashBoard");
                return mv;
            } else {
                System.out.println("Retrived Profile is null");
                mv.addObject("error","Internal Server Error");
                mv.setViewName("error");
                return mv;
            }
        }
        else if(curruser.getRole().equals("[ROLE_DOCTOR]")){
            System.out.println(curruser.toString());
            System.out.println("Fetching Doctor Profile");
            ResponseEntity<Doctor> doctor= userClient.getDoctorProfile(curruser.getMail());
            System.out.println("Fetched Successfully");
            System.out.println(doctor.toString());
            if(doctor != null){
                d=doctor.getBody();
                System.out.println("Fetching doctor schedules");

                System.out.println("Fetched successfully");
                mv.addObject("doctor",d);

                mv.setViewName("dDashboard");
                log.info("Diverting to user DashBoard");
                return mv;
            }
            else{
                mv.addObject("error","Internal Server Error");
                mv.setViewName("error");
                return mv;
            }
        }
        mv.addObject("error","Internal Server Error");
        mv.setViewName("error");
        return mv;
    }
}
