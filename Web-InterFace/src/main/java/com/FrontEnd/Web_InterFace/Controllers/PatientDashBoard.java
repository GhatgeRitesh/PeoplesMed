package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.Configurations.Users;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@RequestMapping("/P")
@Controller
@Log4j2
public class PatientDashBoard {
    @Autowired
    private UserClient userClient;
    @Autowired
    private Patient p;

    private Users users;

    public PatientDashBoard(Users users){this.users=users;}
    @GetMapping("/profile")
    public ModelAndView pProfile(ModelAndView mv){
        log.info("Patient Profile Method Access");
        try{
           ResponseEntity<Patient> p= userClient.getUserProfile(users.getUsername());
            System.out.println( p.toString());
            if(p!=null){
                mv.setViewName("PProfile");
                mv.addObject("Profile",p);
            }
        }catch(Exception e){
            log.info("Error While Feting User Data");
            mv.setViewName("PProfile");
            mv.addObject("Profile","Error while fetching User profile");
            return mv;
        }
        return mv;
    }

    @GetMapping("/listDocs")
    public ModelAndView PDashBoard(ModelAndView mv){
        log.info("docs list activated ");

            List<Doctor> list = userClient.getAllDocs();
            System.out.println("List :- " + list.toString());
            mv.addObject("list", list);
            mv.setViewName("patientDashBoard");
            if(list.isEmpty()){
                log.info(" The list is Empty :");
                mv.addObject("list","The recieved list is empty :");
                mv.setViewName("paitentDashBoard");
            }
            System.out.println("List :- " + list.toString());
            mv.addObject("list", list);
            mv.setViewName("patientDashBoard");

        return mv;
    }
}
