package com.HospitalService.controller;

import com.HospitalService.model.Doctor;
import com.HospitalService.repository.HospitalRepo;
import com.HospitalService.service.DoctorService;
import com.HospitalService.service.HospitalResourceService;
import com.HospitalService.service.HospitalService;
import com.HospitalService.service.ScheduleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/getDocs")
    public ResponseEntity<Doctor> getDocs(){
        log.info("Listing Doctors");
        log.info(doctorService.listDocs().toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
