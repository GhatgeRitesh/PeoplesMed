package com.Database.PeoplesMedDB.Controller;

import com.Database.PeoplesMedDB.Entity.Doctor;
import com.Database.PeoplesMedDB.Entity.Patient;
import com.Database.PeoplesMedDB.Entity.Schedule;
import com.Database.PeoplesMedDB.Repository.DocRepo;
import com.Database.PeoplesMedDB.service.DocService;
import com.Database.PeoplesMedDB.service.PService;
import com.Database.PeoplesMedDB.service.ScheduleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@Log
public class RegController {

    @Autowired
    private final DocService docService;
 //   private final DocRepo docRepo;
    @Autowired
    private ScheduleService scheduleService;

    private final PService pService;
    public RegController(DocService docService , PService pservice/*,DocRepo docRepo */ ,ScheduleService scheduleService){
        this.docService=docService;
       // this.docRepo=docRepo;
        this.pService=pservice;
        this.scheduleService=scheduleService;
    }
    @PostMapping("/AddDoctor")
    public ResponseEntity<Doctor> AddDoc(@RequestBody Doctor doc){
        if(doc==null){
            log.info("Doc Entity received null");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
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
        try{
            pService.savePatient(patient);
        }catch(Exception e){
           log.info("Error While Saving patient "+e);
           return new ResponseEntity<>(patient,HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(patient,HttpStatus.CREATED);
    }



    @PostMapping("/SetSchedule")
    public ResponseEntity<?> saveSchedule(@RequestBody Schedule schedule){
         log.info("DB Service Save Schedule Method accessed");
         if(schedule == null){
             log.info("Entity received empty ");
             return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
         }
        System.out.println(schedule.toString());
         try {
             scheduleService.SaveSchedule(schedule);
             log.info("schedule Saved successfully");
         }
         catch (Exception e){
             log.info( " Error while saving schedule :" + e);
             return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
         return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
