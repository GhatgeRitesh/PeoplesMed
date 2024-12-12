package com.FrontEnd.CustomerService.Service;

import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private DatabaseService databaseService;


    public List<Patient> getAllPatient(){
        return databaseService.getAllPatients();
    }


    public Patient getCurrUser(String mail){
        ResponseEntity<Patient> patient= databaseService.getPatientProfile(mail);

        return patient.getBody();
    }


}
