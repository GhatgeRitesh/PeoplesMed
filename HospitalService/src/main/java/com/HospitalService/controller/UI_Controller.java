package com.HospitalService.controller;

import com.HospitalService.model.Doctor;
import com.HospitalService.model.Hospital;
import com.HospitalService.model.Login;
import com.HospitalService.service.DoctorService;
import com.HospitalService.service.HospitalService;
import com.HospitalService.service.PasswordEncryptionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/Hospital")
@Log
public class UI_Controller {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private PasswordEncryptionService passwordEncryptionService;

    @Autowired
    private DoctorService doctorService;


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
            log.info(encryptedPassword+ "Encrypted Password");
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

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv){
        log.info("Login Form Requested");
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/login_submission")
    public ModelAndView verfiy(@ModelAttribute Login login, ModelAndView mv){
        try{
            if (login == null){throw new RuntimeException("received empty credentials");}
            log.info("Creds recevied"+ login.toString());
            Optional<Hospital> result= hospitalService.getCreds(login);
            if (result.isEmpty()) throw new RuntimeException("Account does not exist");
            String password=login.getPassword();
            passwordEncryptionService.hashPassword(password);
            if(password.equals(result.get().getPassword())){
                Hospital hospital=  result.orElse(null);
                log.info("Current hospital Entity" + hospital.toString());
                mv.addObject("hospital",result);
                mv.setViewName("DashBoard");
            }
            else{
                log.info("invalid password");
                mv.addObject("Error","Invalid Password");
                mv.setViewName("login");
            }
            return mv;
        }catch(Exception e){
            log.info("Exception encountered while verifying login credentials" + e.getMessage());
            mv.addObject("Error ", e.getMessage());
            mv.setViewName("Error");
            return mv;
        }
    }

    @PostMapping("/AddDoctor")
    public ModelAndView addDoctor(@ModelAttribute Doctor doctor, ModelAndView mv){
        try{
            if(doctor == null){throw new RuntimeException("Form received empty");}
            log.info("adding doctor");
            if(doctorService.save(doctor)){
                mv.setViewName("DashBoard");
                return mv;
            }
            else{
                throw new RuntimeException("Error from service");
            }
        }catch (Exception e){
            log.info("Exception while adding doctor: "+ e.getMessage());
            mv.addObject("Error",e.getMessage());
            mv.setViewName("Error");
            return mv;
        }
    }


}
