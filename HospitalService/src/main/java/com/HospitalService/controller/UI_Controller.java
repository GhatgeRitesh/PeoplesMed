package com.HospitalService.controller;

import com.HospitalService.model.Hospital;
import com.HospitalService.service.HospitalService;
import com.HospitalService.service.PasswordEncryptionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Hospital")
@Log
public class UI_Controller {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private PasswordEncryptionService passwordEncryptionService;


    //Hospital Registration Form Controller
    @PostMapping("/Register")
    public ModelAndView hospitalRegistration(@ModelAttribute Hospital hospital, ModelAndView mv){
        log.info("Hospital registration request received.");
        if(hospital == null){
            mv.addObject("Error","Internal Server Issue");
            mv.setViewName("Error");
            return mv;
        }
        try{
            log.info("The Hospital form received as: "+ hospital.toString());
            log.info("Encrypting Password");
            String encryptedPassword= passwordEncryptionService.hashPassword(hospital.getPassword());
            if(encryptedPassword== null){throw new RuntimeException("Password Encryption Failed");}
            hospital.setPassword(encryptedPassword);
            boolean  flag=hospitalService.save(hospital);
            if(!flag){throw new RuntimeException("Internal Server Error");}
            mv.setViewName("DashBoard");
            mv.addObject("Hospital",hospital);
            return mv;
        }catch (Exception e){
            log.info("Exception Occurred while Registration of Data");
            log.info("Exception:-" + e.getMessage());
            mv.addObject("error","Internal Server Error");
            mv.setViewName("Error");
            return mv;
        }
    }
}
