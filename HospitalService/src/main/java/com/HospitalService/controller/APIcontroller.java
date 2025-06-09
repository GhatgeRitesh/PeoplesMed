package com.HospitalService.controller;

import com.HospitalService.model.*;
import com.HospitalService.service.DoctorService;
import com.HospitalService.service.HospitalService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hospital")
@Log
public class APIcontroller {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private DoctorService doctorService;



    @PostMapping("getCityHospitals")
    public ResponseEntity<List<HospitalStatusDTO>> getHospitals(@RequestBody Emergency_Requests emergencyRequests){
        try{
            if(emergencyRequests == null){log.info("Request received empty"); throw new RuntimeException("Internal Server Error");}
            log.info("Requesting hospital Service");
            List<HospitalStatusDTO> list=hospitalService.getCityHospitals(emergencyRequests.getCity());
            if (list == null){throw new RuntimeException("Empty Result retrived");}
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            log.info("Exception occurred : "+ e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }



}
