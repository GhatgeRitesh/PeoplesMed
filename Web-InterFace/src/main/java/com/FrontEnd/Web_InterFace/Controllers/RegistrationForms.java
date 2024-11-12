package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Mail.GMailEntity;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.FeignServices.FeaturesInterfaces;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/Reg")
@Log
public class RegistrationForms {
    @Autowired
    private UserClient userClient;
    @Autowired
    private FeaturesInterfaces features;
    @Autowired
    private GMailEntity gMailEntity;
    @PostMapping("/sub/D")
    public ResponseEntity<Doctor> DocReg(@ModelAttribute Doctor doc){
        log.info("The Doctor Form Received");
        System.out.println(doc.toString());

        try {
            gMailEntity.setReceiver(doc.getEmail());
            gMailEntity.setRole("Doc");
            gMailEntity.setSubject("Register");
            features.SendEmail(gMailEntity);
            doc.setRole("Doctor");
            ResponseEntity<?> response= userClient.AddDoc(doc);
            if(response.getStatusCode().is2xxSuccessful()){
                features.SendEmail(gMailEntity);
                log.info("User Registered Successfully");
            }
        }catch(Exception e){
            log.info("Error while Saving Doctor :"+e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(doc, HttpStatus.CREATED);
    }

    @PostMapping("/sub/P")
    public ModelAndView PReg(@ModelAttribute Patient P,ModelAndView mv){
        log.info("The Patient Form is received");
        if(P==null){
            log.info("The Patient Body is Empty!");
            mv.setViewName("/error");
            mv.addObject("error","Entity recieved empty Internale Server Error");
            return mv;
        }
        gMailEntity.setRole("Pat");
        gMailEntity.setSubject("Register");
        gMailEntity.setReceiver(P.getEmail());
        try{
          P.setRole("Patient");

          ResponseEntity<?> res= userClient.savePatient(P);
          if(res.getStatusCode().is2xxSuccessful()){
              features.SendEmail(gMailEntity);
          }
        }catch(Exception e){
            log.info("Error While Saving Patient :"+e);
            mv.setViewName("error");
            mv.addObject("error", HttpStatus.EXPECTATION_FAILED);
            return mv;
        }
        mv.setViewName("login");
       return mv;
    }
}
