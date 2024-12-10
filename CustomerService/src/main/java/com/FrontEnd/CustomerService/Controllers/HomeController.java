package com.FrontEnd.CustomerService.Controllers;

import com.FrontEnd.CustomerService.Configurations.Users;
import com.FrontEnd.CustomerService.Configurations.currUser;
import com.FrontEnd.CustomerService.EntityManager.PaymentEntity.PaymentInfo;
import com.FrontEnd.CustomerService.EntityManager.PaymentEntity.StripeResponse;
import com.FrontEnd.CustomerService.EntityManager.Users.Doctor;
import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import com.FrontEnd.CustomerService.FeignServices.PaymentService;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private DatabaseService databaseService;

    @Autowired
    private PaymentService paymentService;
    public HomeController(Users users, DatabaseService databaseService){this.curruser=curruser;this.databaseService = databaseService;}

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
                Patient patient= databaseService.getPatientProfile(curruser.getMail()).getBody();
                log.info("Retrival Process Completed"+patient.toString() );
                mv.addObject("patient",patient);
            }
            if(role.equals("[ROLE_DOCTOR]")){
                log.info("Patient Entity Retriving");
                Doctor doctor= databaseService.getDoctorProfile(curruser.getMail()).getBody();
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

    @GetMapping("/checkPayment")
    public String checkPayment(){
        System.out.println("Checking the payment health");
        PaymentInfo info =new PaymentInfo();
        info.setAmount((long)10);
        info.setName("consultancy fee");
        info.setCurrency("USD");
        info.setQuantity((long) 1);
        ResponseEntity<StripeResponse> response=  paymentService.getCheckoutLink(info);
        System.out.println("response received successfully");
        System.out.println(response.getBody());
        System.out.println("redirecting to the url");
        return "redirect:"+ response.getBody().getSessionUrl();
    }



}
