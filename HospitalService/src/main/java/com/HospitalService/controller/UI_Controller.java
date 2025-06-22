package com.HospitalService.controller;

import com.HospitalService.model.*;
import com.HospitalService.service.DoctorService;
import com.HospitalService.service.HospitalService;
import com.HospitalService.service.PasswordEncryptionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
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

    @Autowired
    private User user;


    private Long hospital_id;

    @GetMapping("/Hospital_Registration")
    public ModelAndView hospitalForm(ModelAndView mv){
        log.info("Hospital Registration form Requested");
        mv.setViewName("hospital_registration_form");
        return mv;
    }


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
            Hospital validate= hospitalService.getHosital(hospital.getName(), hospital.getContact());
            if (validate == null) throw new RuntimeException("Hospital Not Registered !");
            hospital_id=validate.getId();
            mv.setViewName("Doctor");
            mv.addObject("Hospital",validate);
            return mv;
        }catch (Exception e){
            log.info("Exception Occurred while Registration of Data");
            log.info("Exception:-" + e.getMessage());
            mv.addObject("error","Internal Server Error");
            mv.setViewName("Error");
            return mv;
        }
    }

    @GetMapping("/addDoctorForm")
    public ModelAndView docform(ModelAndView mv){
        log.info("Doctor form Requested");
        mv.setViewName("Doctor");
        mv.addObject("hospital_id",hospital_id);
        return mv;
    }
    @PostMapping("/AddDoctor")
    public ModelAndView addDoctor(@RequestParam("hospitalId")Long hospital_id, @ModelAttribute Doctor doctor, ModelAndView mv){
        try{
            if(doctor == null){throw new RuntimeException("Form received empty");}
            log.info("adding doctor:- "+ doctor.toString());
            Hospital hospital= hospitalService.getHospitalByID(hospital_id);
            if (hospital == null) throw new RuntimeException("Hospital Not Found !!!!");
            doctor.setHospital(hospital);
            if(doctorService.save(doctor)){
                mv.setViewName("hospital_status");
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

    @GetMapping("/updateStatusForm")
    public ModelAndView getStatusform(ModelAndView mv){
        log.info("Status update form requested");
        log.info("Setting hospital id to "+ hospital_id);
        mv.addObject("hospital_id",hospital_id);
        mv.setViewName("hospital_status");
        return mv;
    }

    @PostMapping("/setStatus")
    public ModelAndView setHospitalStatus(@RequestParam("hospitalId")Long hospital_id,@ModelAttribute HospitalStatus hospitalStatus, ModelAndView mv){
        try{
            log.info("Hospital status:- "+ hospitalStatus.toString());
            Hospital hospital= hospitalService.getHospitalByID(hospital_id);
            if (hospital == null) throw new RuntimeException("Hospital Not Found !!!!");
            HospitalStatus status= hospitalService.getHospitalStatus(hospital.getId());
            hospitalStatus.setHospital(hospital);
            if(hospitalService.setStatus(hospitalStatus)) {
             log.info("Hospital Status Updated Successfully");
             mv.addObject("hospital",hospital);
             mv.addObject("status",status);
             mv.setViewName("DashBoard");
            }
            else
                throw new RuntimeException("Error while saving status");
            return mv;
        }catch (Exception e){
            log.info("Exception occurred: "+ e.getMessage());
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
            Optional<Hospital> hospital= hospitalService.getCreds(login);
            if (hospital.isEmpty()) throw new RuntimeException("Account does not exist");
            String password=login.getPassword();
            String encryptedPassword=passwordEncryptionService.hashPassword(password);
            HospitalStatus status= hospitalService.getHospitalStatus(hospital.get().getId());
            System.out.println(status.toString());
            user.setId(hospital.get().getId());
          //  if(status == null) throw new RuntimeException("Failed to fetch the hospital status");
            if(encryptedPassword.equals(hospital.get().getPassword())){
                Hospital hos=  hospital.orElse(null);
                log.info("Current hospital Entity" + hospital.toString());
                mv.addObject("hospital",hos);
                mv.addObject("status",status);
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

    @GetMapping("/updateHospitalStatus")
    public ModelAndView getform(ModelAndView mv){
        log.info("status form requested");
        log.info("Fetching current hospital info");
        HospitalStatus hospitalStatus=hospitalService.getHospitalStatus(hospital_id);
        if(hospitalStatus != null) log.info("current hospital status fetched successfully");
        mv.addObject("status",hospitalStatus);
        mv.addObject("hospital_id",hospital_id);
        mv.setViewName("status_Update");
        return mv;
    }

    @PostMapping("/updateStatus")
    public ModelAndView updateHospitalStatus(@RequestParam("hospitalId")Long hospital_id,@ModelAttribute HospitalStatus hospitalStatus, ModelAndView mv){
        try{
          log.info("Updating hospital status");
          boolean flag= hospitalService.updateHospitalStatus(hospital_id,hospitalStatus);
          if(!flag) throw new RuntimeException("Service Expectation Failed");
          Hospital hospital= hospitalService.getHospitalByID(hospital_id);
          if (hospital == null) throw new RuntimeException("Hospital Not Found !!!!");
          HospitalStatus status= hospitalService.getHospitalStatus(hospital.getId());
          hospitalStatus.setHospital(hospital);
          if(hospitalService.updateHospitalStatus(hospital_id,hospitalStatus)) {
              log.info("Hospital Status Updated Successfully");
              mv.addObject("hospital",hospital);
              mv.addObject("status",status);
              mv.setViewName("DashBoard");
          }
          return mv;
        }catch (Exception e){
          log.info("Exception Failed: "+ e.getMessage());
          mv.setViewName("Error");
          mv.addObject("error",e.getMessage());
          return mv;
        }
    }

    @GetMapping("/Iframe")
    public ModelAndView getIframe(ModelAndView mv){
        log.info("Iframe Launched");
        mv.setViewName("Iframe");
        return mv;
    }



}
