package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.Configurations.Users;
import com.FrontEnd.Web_InterFace.Configurations.currUser;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
@Log
public class HomeController {

    @Autowired
    private currUser curruser;

    @Autowired
    private UserClient userClient;
    public HomeController(Users users,UserClient userClient){this.curruser=curruser;this.userClient=userClient;}

    @GetMapping("/Welcome")
    public ModelAndView home(ModelAndView mv){
        mv.setViewName("Welcome");
        return mv;
    }

    @GetMapping("/Profile")
    public ModelAndView UserProfile(ModelAndView mv){
        log.info("User Profile Page Activated");
        try{
            String role= curruser.getRole();
            System.out.println(role);
            if(role.equals("[ROLE_PATIENT]")){
                log.info("Patient Entity Retriving");
                Patient patient= userClient.getPatientProfile(curruser.getMail()).getBody();
                log.info("Retrival Process Completed"+patient.toString() );
                mv.addObject("patient",patient);
            }
            if(role.equals("[ROLE_DOCTOR]")){
                log.info("Patient Entity Retriving");
                Doctor doctor= userClient.getDoctorProfile(curruser.getMail()).getBody();
                if(doctor == null){log.info("Users role detected as Doctor retrival process retrived null entity");}
                log.info(doctor.toString());
                mv.addObject("doctor",doctor);
            }
        }catch(Exception e){
            mv.setViewName("error");
            mv.addObject("error","failed to fetch user details");
            log.info(e+" ");
            return mv;
        }
        mv.setViewName("profile");
        return mv;
    }
}
