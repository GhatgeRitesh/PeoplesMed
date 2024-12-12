package com.Database.PeoplesMedDB.Controller;

import com.Database.PeoplesMedDB.Entity.*;
import com.Database.PeoplesMedDB.Repository.BookedSchedulesRepo;
import com.Database.PeoplesMedDB.Repository.DocRepo;
import com.Database.PeoplesMedDB.Repository.PRepo;
import com.Database.PeoplesMedDB.service.DocService;
import com.Database.PeoplesMedDB.service.PService;
import com.Database.PeoplesMedDB.service.ScheduleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
public class Controller {

    @Autowired
    private final DocService docService;
    @Autowired
    private PRepo pRepo;
    @Autowired
    private DocRepo docRepo;
    @Autowired
    private final PService pService;

    @Autowired
    private BookedSchedulesRepo bookedSchedulesRepo;



    private ScheduleService scheduleService;
    public Controller(DocService docService , PService pservice, ScheduleService scheduleService){
        this.docService=docService;
        this.pService=pservice;
//        this.scheduleRepo = scheduleRepo;
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
        log.info("Completed Fetching user details");
        if (p == null){
            log.info("The patient Recieved Null terminating Process");
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @PostMapping("/GetDoctor")
    public ResponseEntity<?> getDoc(@RequestBody String email){
        System.out.println("Method Accessed");
        Doctor doctor = docService.getDoctor(email);
        if(doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        }
        System.out.println("doctor is null");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/saveASchedule")
    public void saveASchedule(@RequestBody Appointments appointments){
        scheduleService.saveASchedule(appointments);
    }

    @PostMapping("/getASchedule")
    public List<Appointments> getAschedule(@RequestParam Long d_id,@RequestParam String Date ){
        // Appointments
        log.info("GetASchedule Activated");
        return scheduleService.getASchedule(d_id,Date);
    }

    @PostMapping("/getBSchedulePatient")
    public List<BookedSchedules> getBSchedulePatient(@RequestBody Long p_Id){
        log.info("Fetching Patient Schedules");
        System.out.println("id : "+ p_Id);
       return scheduleService.getBSchedulePatient(p_Id);
    }
    @PostMapping("/getBScheduleDoctor")
    public List<BookedSchedules> getBScheduleDoctor(@RequestBody Long d_Id){
        log.info("Fetching Doctor Schedules");
        System.out.println("id : "+ d_Id);
        return scheduleService.getBScheduleDoctor(d_Id);
    }

    @PostMapping("/updateASchedule")
    public int updateASchedule(@RequestBody BookedSchedules bookedSchedules){
        Long d_id= bookedSchedules.getDId();
        String time= bookedSchedules.getSlotTime();
        String  date= bookedSchedules.getSlotDate();
        return scheduleService.updateASchedule(d_id,time,date);
    }

    @PostMapping("/saveBookedSchedule")
    public void saveSchedule(@RequestBody BookedSchedules bookedSchedules){
        System.out.println("bookedSchedule");
        log.info("Saving BookedSchedules");
        try{
            bookedSchedulesRepo.save(bookedSchedules);
            log.info("Schedule have been booked");
        }catch (Exception e){
            log.info("Exception occured while saving schedule");
        }
    }
}
