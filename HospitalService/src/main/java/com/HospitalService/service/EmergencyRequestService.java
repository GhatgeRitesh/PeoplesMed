package com.HospitalService.service;

import com.HospitalService.model.Emergency_Requests;
import com.HospitalService.repository.EmergencyRequestRepo;
import jdk.jfr.BooleanFlag;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class EmergencyRequestService {

    @Autowired
    private EmergencyRequestRepo emergencyRequestRepo;

    public Boolean SaveRequest(Emergency_Requests emergencyRequests){
        try{
            if(emergencyRequests == null){throw  new RuntimeException("Request Body Received Empty");}
            emergencyRequestRepo.save(emergencyRequests);
            log.info("Request Saved Successfully");
            return true;
        }catch(Exception e){
            log.info("Exception Occurred while saving request: "+ e.getMessage());
            return false;
        }

    }

    public Emergency_Requests getRequest(Long id){
        try{
            if(id == null) throw new RuntimeException("Id value is null");
            log.info("finding emergency request for id"+ id);
            Emergency_Requests request=emergencyRequestRepo.getReferenceById(id);
            log.info("Fetched successfully Status is :"+ request.getAcceptanceStatus());

            return request;
        }catch (Exception e){
            log.info("Exception while retrieving request id:"+id+" with exception:"+e.getMessage());
            return null;
        }
    }



    
}
