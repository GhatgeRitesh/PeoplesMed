package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Patient;
import com.Database.PeoplesMedDB.Repository.PRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Log
public class PService {
    @Autowired
    private PRepo pRepo;

    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        if(patient == null ){
            log.info("The Patient Body is Empty ");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        log.info("The Patient Body received :"+ patient.toString());
        try {
            pRepo.save(patient);
            log.info("Patient Registered Successfully");
        }catch(Exception e){
            log.info("Error while Saving Patient :"+ e);
            return new ResponseEntity<>(patient,HttpStatus.EXPECTATION_FAILED);
        }
       return new ResponseEntity<>(patient,HttpStatus.CREATED);
    }

    public List<Patient> findAll(){
        List<Patient> list=pRepo.findAll();
        return list;
    }
    public Patient getPatient(String Email){
         Patient patient = pRepo.findByEmail(Email);
         return patient;
    }
}
