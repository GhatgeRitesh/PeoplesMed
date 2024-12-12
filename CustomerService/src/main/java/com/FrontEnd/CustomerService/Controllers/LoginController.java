package com.FrontEnd.CustomerService.Controllers;

import com.FrontEnd.CustomerService.EntityManager.Users.BookedSchedules;
import com.FrontEnd.CustomerService.EntityManager.Users.Doctor;
import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import com.FrontEnd.CustomerService.Service.DoctorService;
import com.FrontEnd.CustomerService.Service.PatientService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.FrontEnd.CustomerService.Configurations.currUser;
import com.FrontEnd.CustomerService.Service.scheduleService;

import java.util.List;


@Controller
@RequestMapping("/login")
@Log
public class LoginController {

    @Autowired
    private currUser curruser;

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private Patient p;

    @Autowired
    private Doctor d;

    @Autowired
    private scheduleService scheduleservice;

    public LoginController(currUser curruser){
        this.curruser=curruser;
    }

    @GetMapping()
    public ModelAndView loginform(ModelAndView mv){
        log.info("Login Form Access");
        mv.setViewName("PLogin");
        return mv;
    }
    @GetMapping("/Failure")
    public ModelAndView failure(ModelAndView mv){
        mv.setViewName("loginFailure");
        return mv;
    }

    @GetMapping("/profile")
    public ModelAndView pProfile(ModelAndView mv) {
        log.info("Fetching User Data");
        if (curruser.getRole().equals("[ROLE_PATIENT]")) {
            ResponseEntity<Patient> patient = databaseService.getPatientProfile(curruser.getMail());
            if (patient != null) {
                p = patient.getBody();
                curruser.setName(p.getName());
                System.out.println(p.getP_id() + "This is patient Id");
                try {
                    log.info("Fetching Patient Schedules");
                    List<BookedSchedules> schedules = databaseService.getBSchedulePatient(p.getP_id());
                    System.out.println(schedules.toString());
                    mv.addObject("schedules",schedules);
                    log.info("Fetched Patient Schedules");
                }catch (Exception e){
                    log.info("Exception Occured while Fetching Schedules");
                }
                mv.setViewName("pDashboard");
                mv.addObject("patient", p);

                log.info("Diverting to user DashBoard");
                return mv;
            } else {
                System.out.println("Retrived Profile is null");
                mv.addObject("error","Internal Server Error");
                mv.setViewName("error");
                return mv;
            }
        }
        else if(curruser.getRole().equals("[ROLE_DOCTOR]")){
            System.out.println(curruser.toString());
            System.out.println("Fetching Doctor Profile");
            ResponseEntity<Doctor> doctor= databaseService.getDoctorProfile(curruser.getMail());
            System.out.println("Fetched Successfully");
            System.out.println(doctor.toString());
            if(doctor != null){
                d=doctor.getBody();
                System.out.println(d.getD_id() + "This is Doctor Id");

                try {
                    log.info("Fetching Doctor Schedules");
                    List<BookedSchedules> schedules = databaseService.getBScheduleDoctor(d.getD_id());
                    System.out.println(schedules.toString());
                    log.info("Fetched Doctor Schedules");
                    mv.addObject("schedules",schedules);
                }catch (Exception e){
                     log.info("Exception occured fetching schedules");
                }


                mv.addObject("doctor",d);

                mv.setViewName("dDashboard");
                log.info("Diverting to user DashBoard");
                return mv;
            }
            else{
                mv.addObject("error","Internal Server Error");
                mv.setViewName("error");
                return mv;
            }
        }
        mv.addObject("error","Internal Server Error");
        mv.setViewName("error");
        return mv;
    }
}
