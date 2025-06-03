package com.HospitalService.service;

import com.HospitalService.model.Hospital;
import com.HospitalService.model.HospitalStatus;
import com.HospitalService.model.HospitalStatusDTO;
import com.HospitalService.repository.HospitalRepo;
import com.HospitalService.repository.HospitalStatusRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class HospitalService {
    @Autowired
    private HospitalRepo hospitalRepo;

    @Autowired
    private HospitalStatusRepo hospitalStatusRepo;

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

    public List<HospitalStatusDTO> getCityHospitals(String city){
        try{
            if(city == null){throw new RuntimeException("city value is null");}
            List<HospitalStatusDTO> list= hospitalRepo.findHospitalStatusByCity(city);
            log.info("Hospital Data Fetched as : "+ list.toString());
            return list;
        }catch(Exception e){
            log.info("Exception Occurred while fetching Hospital DTO: "+ e.getMessage());
            return null;
        }
    }

    public Boolean setStatus(HospitalStatus hospitalStatus){
        try{
            hospitalStatusRepo.save(hospitalStatus);
            return true;
        }catch (Exception e){
            log.info("Error while saving hospital status: "+ e.getMessage());
            return false;
        }
    }
}
