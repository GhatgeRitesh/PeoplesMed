package com.HospitalService.controller;

import com.HospitalService.model.Doctor;
import com.HospitalService.service.DoctorService;
import com.HospitalService.service.HospitalResourceService;
import com.HospitalService.service.HospitalService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hos")
@Log
public class APIcontroller {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private HospitalResourceService hospitalResourceService;


    @GetMapping("/getDocs")
    public ResponseEntity<Doctor> getDocs(){
        log.info("Listing Doctors");
        log.info(doctorService.listDocs().toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/cityHops")
    public ResponseEntity<?> getcityHops(String city){
        log.info("Retrieving Hospital Details for city: "+ city);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/get-patient/Hospitals")
//    public ResponseEntity<?> getCityHospitals(@RequestBody User user){
//        //
//       // List<Hospital> hospitalList=hospitalService.getCityHospital(user.city);
//
//    }
}
