package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.Configurations.Users;
import com.FrontEnd.Web_InterFace.EntityManager.Users.CacheData;
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


@RequestMapping("/p")
@Controller
@Log4j2
public class PatientDashBoard {
    @Autowired
    private UserClient userClient;
    @Autowired
    private Patient p;

    private CacheData cacheData;

    private Users users;

    public PatientDashBoard(Users users, CacheData cacheData){this.users=users; this.cacheData=cacheData;}
    @GetMapping("/profile")
    public ModelAndView pProfile(ModelAndView mv){
        log.info("Patient Profile Method Access");
        try{
           ResponseEntity<Patient> p= userClient.getUserProfile(users.getUsername());
            if(p!=null){
                mv.setViewName("PProfile");
                mv.addObject("Profile",p);
            }
            else{
                System.out.println("Retrived Profile is null");
            }
        }catch(Exception e){
            log.info("Error While Feting User Data");
            mv.setViewName("PProfile");
            mv.addObject("Profile","Error while fetching User profile");
            return mv;
        }
        return mv;
    }

    @GetMapping("/findDoctor")
    public ModelAndView PDashBoard(ModelAndView mv){
        log.info("docs list activated ");
            List<Doctor> list = userClient.getAllDocs();
            cacheData.setDocList(list);
            System.out.println("List :- " + list.toString());
            mv.addObject("list", list);
            mv.setViewName("patientDashBoard");
            if(list.isEmpty()){
                log.info(" The list is Empty :");
                mv.addObject("list","The recieved list is empty :");
                mv.setViewName("FindDoctor");
            }
            System.out.println("List :- " + list.toString());
            mv.addObject("list", list);
            mv.setViewName("FindDoctor");

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
