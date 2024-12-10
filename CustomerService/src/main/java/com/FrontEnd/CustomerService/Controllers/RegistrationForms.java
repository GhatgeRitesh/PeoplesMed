package com.FrontEnd.CustomerService.Controllers;

import com.FrontEnd.CustomerService.EntityManager.Mail.GMailEntity;
import com.FrontEnd.CustomerService.EntityManager.Users.Doctor;
import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import com.FrontEnd.CustomerService.FeignServices.MailService;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/Reg")
@Log
public class RegistrationForms {
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private MailService features;
    @Autowired
    private GMailEntity gMailEntity;
    @PostMapping("/sub/D")
    public ModelAndView DocReg(@ModelAttribute Doctor doc, ModelAndView mv){
        log.info("The Doctor Form Received");
        System.out.println(doc.toString());

        try {
            doc.setRole("Doctor");
            ResponseEntity<?> response= databaseService.AddDoc(doc);
            if(response.getStatusCode().is2xxSuccessful()){
                log.info("User Registered Successfully");
                boolean flag= features.RegisterDoctorMail(doc);
                if(flag) log.info("User Registered Successfully");
                else log.info("Mail Not Sent");
            }
        }catch(Exception e){
            log.info("Error while Saving Doctor :"+e);
            mv.setViewName("error");
            return mv;
        }
        mv.setViewName("PLogin");
        return mv;
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

        try{
          P.setRole("Patient");

          ResponseEntity<?> res= databaseService.savePatient(P);
          if(res.getStatusCode().is2xxSuccessful()){
              log.info("User Registered Successfully");
              boolean flag= features.RegisterPatMail(P);
              if(flag) log.info("User Registered Successfully");
              else log.info("Mail Not Sent");
          }
        }catch(Exception e){
            log.info("Error While Saving Patient :"+e);
            mv.setViewName("error");
            mv.addObject("error", HttpStatus.EXPECTATION_FAILED);
            return mv;
        }
        mv.setViewName("PLogin");
       return mv;
    }

}
