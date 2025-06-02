package com.HospitalService.service;

import com.HospitalService.model.Hospital;
import com.HospitalService.repository.HospitalRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class HospitalService {
    @Autowired
    private HospitalRepo hospitalRepo;

    public boolean save(Hospital hospital){
        if(hospital == null) {
            log.info("Object received empty");
            return false;
        }
        try{
            log.info("Saving hospital Details");
            hospitalRepo.save(hospital);
            log.info("Hospital Details saved successfully");
            return true;
        }catch(Exception e){
            log.info("Exception occurred while savinf hospital details");
            log.info("Exception:- "+ e);
            return false;
        }
    }
}
