package com.HospitalService.controller;

import com.HospitalService.model.*;
import com.HospitalService.repository.EmergencyRequestRepo;
import com.HospitalService.service.DoctorService;
import com.HospitalService.service.EmergencyRequestService;
import com.HospitalService.service.FilterService;
import com.HospitalService.service.HospitalService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private User user;
    @Autowired
    private EmergencyRequestRepo emergencyRequestRepo;



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
    public ResponseEntity<?> getAcceptanceStatus(@RequestBody Long RequestID){
        log.info("Getting Acceptance Status for Hospital Id :"+ RequestID);
        try {
            if (RequestID == null) throw new RuntimeException("eroor in service because of id null");
            else{
                Emergency_Requests emergencyRequests = emergencyRequestService.getRequest(RequestID);
                if(emergencyRequests == null) throw new RuntimeException("get request received null");
                if(emergencyRequests.getAcceptanceStatus() == null) return new ResponseEntity<>(null,HttpStatus.OK);
                Map<String, String> result = new HashMap<>();
                result.put("acceptanceStatus", emergencyRequests.getAcceptanceStatus());
                return new ResponseEntity<>(result, HttpStatus.OK);

            }
        }catch (Exception e){
            log.info("Exception occurred : "+ e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/getERequest")
    public ResponseEntity<?> getRequest(){
      log.info("Fetching Emergency Request for Hospital Id:" +user.getId() );
      Long id=user.getId();
      List<Emergency_Requests> result= emergencyRequestRepo.findByHospital_Id(id);
      //log.info("Fetched Emergency Requests: "+ result.toString());
        List<EmergencyRequestDTO> dtoList = result.stream().map(r -> new EmergencyRequestDTO(
                r.getId(),
                r.getName() != null ? r.getName() : "",
                r.getCondition() != null ? r.getCondition() : "",
                r.getAddress() != null ? r.getAddress() : "",
                r.getContact() != null ? r.getContact() : "",
                r.getAge(),
                r.getCity() != null ? r.getCity() : "",
                r.getAmbulanceNeed(),
                r.getEmergencyType() != null ? r.getEmergencyType() : "",
                r.getAcceptanceStatus()
        )).toList();

        return new ResponseEntity<>(dtoList,HttpStatus.OK);
    }

    @PostMapping("/updateRequestStatus")
    public ResponseEntity<?> updateStatus(@RequestBody Map<String, Object> payload){
        Long requestId = Long.parseLong(payload.get("requestId").toString());
        String status = payload.get("acceptanceStatus").toString();

        log.info("Updating Request Status as: " + status);
        try {
            int result = emergencyRequestRepo.updateAcceptanceStatusById(requestId, status.toLowerCase());
            if (result == 0) throw new RuntimeException("Failed to update status");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.info("Exception Occurred: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
