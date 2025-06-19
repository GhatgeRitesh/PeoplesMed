package com.HospitalService.controller;

import com.HospitalService.model.*;
import com.HospitalService.service.DoctorService;
import com.HospitalService.service.EmergencyRequestService;
import com.HospitalService.service.FilterService;
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
    @Autowired
    private FilterService filterService;
    @Autowired
    private EmergencyRequestService emergencyRequestService;



    @PostMapping("/getCityHospitals")
    public ResponseEntity<List<HospitalStatusDTO>> getHospitals(@RequestBody Emergency_Requests emergencyRequests){
        try{
            if(emergencyRequests == null){log.info("Request received empty"); throw new RuntimeException("Internal Server Error");}
            log.info("Requesting hospital Service");
            log.info("FEtching Hospitals for city:"+ emergencyRequests.getCity());

            List<HospitalStatusDTO> list=hospitalService.getCityHospitals(emergencyRequests.getCity());
            if (list == null){throw new RuntimeException("Empty Result retrived");}
            List<HospitalStatusDTO> result=filterService.getFilteredHospitals(list,emergencyRequests);
            if(result == null) {log.info("Filtering Failed Sending Raw Data");return new ResponseEntity<>(list,HttpStatus.OK);}
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            log.info("Exception occurred : "+ e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/saveEmergencyRequest")
    public ResponseEntity<?> saveEmergencyRequest(@RequestBody Emergency_Requests emergencyRequests){
        log.info("saving started");
        try {
            if(emergencyRequests == null) throw  new RuntimeException("request received empty while saving");
            if(!emergencyRequestService.SaveRequest(emergencyRequests)) throw  new RuntimeException("error in service layer");
            else log.info("request saved successfully");
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.info("Exception occurred : "+ e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PostMapping("/getAcceptanceStatus")
    public ResponseEntity<?> getAcceptanceStatus(Long RequestID){
        log.info("get requset started");
        try {
            if (RequestID == null) throw new RuntimeException("eroor in service because of id null");
            else{
                Emergency_Requests emergencyRequests = emergencyRequestService.getRequest(RequestID);
                if(emergencyRequests == null) throw new RuntimeException("get request received null");
                if(emergencyRequests.getAcceptanceStatus() == null) return new ResponseEntity<>(null,HttpStatus.OK);
                else return new ResponseEntity<>(emergencyRequests.getAcceptanceStatus(),HttpStatus.OK);
            }
        }catch (Exception e){
            log.info("Exception occurred : "+ e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
