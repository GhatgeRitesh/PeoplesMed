package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.Mail.GMailEntity;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Appointments;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.FeignServices.FeaturesService;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/Reg")
@Log
public class RegistrationForms {
    @Autowired
    private UserClient userClient;
    @Autowired
    private FeaturesService features;
    @Autowired
    private GMailEntity gMailEntity;
    @PostMapping("/sub/D")
    public ModelAndView DocReg(@ModelAttribute Doctor doc, ModelAndView mv){
        log.info("The Doctor Form Received");
        System.out.println(doc.toString());

        try {
            doc.setRole("Doctor");
            ResponseEntity<?> response= userClient.AddDoc(doc);
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

          ResponseEntity<?> res= userClient.savePatient(P);
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

    @GetMapping("/getASchedule")
    public String check(){
//        List<Appointments> appointments= userClient.getAschedule(1L,"2024-12-04");
        return "";
    }
}
