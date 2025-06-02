package com.FrontEnd.CustomerService.Controllers;

import com.FrontEnd.CustomerService.Configurations.currUser;
import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import com.FrontEnd.CustomerService.Service.PatientService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@RequestMapping("/home")
public class EmergencyController {
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private currUser curruser;

    @GetMapping("/GetUserDetails")
    public ResponseEntity<Patient> getDetails(){
        log.info("Request from emergency service for patient details");
        Patient patient=databaseService.getPatientProfile(curruser.getMail()).getBody();
        log.info("current patient details "+patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
}
