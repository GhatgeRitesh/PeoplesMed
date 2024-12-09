package com.FrontEnd.Web_InterFace.Service;

import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.FeignServices.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private DatabaseService databaseService;

    @Cacheable(value = "patientCache" , key = "'allPatients'")
    public List<Patient> getAllPatient(){
        return databaseService.getAllPatients();
    }

    @Cacheable(value = "userCache" , key = " 'patientCache' ")
    public Patient getCurrUser(String mail){
        ResponseEntity<Patient> patient= databaseService.getPatientProfile(mail);
        return patient.getBody();
    }


}
