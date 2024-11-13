package com.Database.PeoplesMedDB.Controller;

import com.Database.PeoplesMedDB.Entity.Doctor;
import com.Database.PeoplesMedDB.Entity.Patient;
import com.Database.PeoplesMedDB.Entity.Schedule;
import com.Database.PeoplesMedDB.Repository.DocRepo;
import com.Database.PeoplesMedDB.Repository.PRepo;
import com.Database.PeoplesMedDB.service.DocService;
import com.Database.PeoplesMedDB.service.PService;
import com.Database.PeoplesMedDB.service.ScheduleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@Log
public class RegController {

    @Autowired
    private final DocService docService;
    @Autowired
    private PRepo pRepo;
    @Autowired
    private DocRepo docRepo;
    @Autowired
    private ScheduleService scheduleService;
    private final PService pService;
    public RegController(DocService docService , PService pservice,ScheduleService scheduleService){
        this.docService=docService;
        this.pService=pservice;
        this.scheduleService=scheduleService;
    }
    @PostMapping("/AddDoctor")
    public ResponseEntity<Doctor> AddDoc(@RequestBody Doctor doc){
        if(doc==null){
            log.info("Doc Entity received null");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String Password = doc.getPassword();
        doc.setPassword(encoder.encode(Password));
        log.info("The doc Entity received in DBservice: "+doc.toString());
        try{
            docService.save(doc);
        }catch(Exception e){
            log.info("Exception while saving doctor :"+e);
            return new ResponseEntity<>(doc,HttpStatus.EXPECTATION_FAILED);
        }
        log.info("The Doctor is been registered");
        return new ResponseEntity<>(doc,HttpStatus.CREATED);
    }
    @PostMapping("/AddPatient")
    public ResponseEntity<Patient> save_Patient(@RequestBody Patient patient){
        if(patient==null){
            log.info("Patient Entity is null");
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        log.info("Patient Saving process is started");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String Password = patient.getPassword();
        patient.setPassword(encoder.encode(Password));
        System.out.println(patient.toString());
        try{
            pService.savePatient(patient);
        }catch(Exception e){
           log.info("Error While Saving patient "+e);
           return new ResponseEntity<>(patient,HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(patient,HttpStatus.CREATED);
    }
    @GetMapping("/getAllDocs")
    public List<Doctor> getAll(){
        log.info("Doc list Generation started");
        try {
            List<Doctor> list = docService.getAll();
            log.info("Doc list Created successfully");
            return list;
        }catch (Exception e){
            log.info("Error occured while trying to get doc list :"+e);
        }
        return null;
    }
    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){
        log.info("Retriving patient list");
        try{
            List<Patient> list=pService.findAll();
            log.info("List created successfully");
            return list;
        }catch(Exception e){
            log.info("Error while creating patient list");
            return null;
        }
    }
    @PostMapping("/getPUser")
    public ResponseEntity<?> fetchUser(@RequestBody String EMail){
        log.info("The User Details Fetching");
        Patient p= pRepo.findByEmail(EMail);
        if (p == null){
            log.info("The patient Recieved Null terminating Process");
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @PostMapping("/GetDoctor")
    public ResponseEntity<?> getDoc(@RequestParam String email){
        System.out.println("Method Accessed");
        Doctor doctor = docService.getDoctor(email);
        if(doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        }
        System.out.println("doctor is null");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/getSchedule")
    public  ResponseEntity<List<Schedule>> getSchedules(@RequestParam Long doc_id,@RequestParam String date){
        List<Schedule> schedules = scheduleService.getScheduleById(doc_id,date);
        return  new ResponseEntity<>(schedules,HttpStatus.OK);
    }
    @PostMapping("/saveSchedule")
    public ResponseEntity<?> saveSchedules(@ModelAttribute Schedule schedule){
        scheduleService.SaveSchedule(schedule);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
