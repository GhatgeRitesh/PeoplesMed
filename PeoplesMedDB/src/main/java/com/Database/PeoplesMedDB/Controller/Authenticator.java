package com.Database.PeoplesMedDB.Controller;
import com.Database.PeoplesMedDB.Entity.Doctor;

import com.Database.PeoplesMedDB.Entity.Patient;
import com.Database.PeoplesMedDB.Entity.Users;
import com.Database.PeoplesMedDB.Repository.DocRepo;
import com.Database.PeoplesMedDB.Repository.PRepo;
import com.Database.PeoplesMedDB.service.DocService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Log
public class Authenticator {

    @Autowired
    private DocRepo docRepo;

    @Autowired
    private PRepo pRepo;

    @Autowired
    private DocService docService;
    public Authenticator(DocRepo docRepo, PRepo pRepo, DocService docService) {
        this.docRepo = docRepo;
        this.pRepo = pRepo;
        this.docService=docService;
    }

    @PostMapping("/ValidateUser")
    public Users verifyUser(@RequestBody Users user) {

        System.out.println("DB Process Started for Login");

        // Check if user fields are null
        if (user == null) {
            log.info("The login form data received is empty");
            return null;
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

        System.out.println("The User from Authenticator"+ user.toString() );
        System.out.println("Entity Retrival process started");
        // Check if the user is a doctor
        Doctor doctor = docService.getDoctor(user.getUsername());
        System.out.println("Entity is Retrived" + doctor.toString());
        // Directly fetch the doctor
        if (doctor != null) {
            System.out.println("Checking doctor creds with bycrpt");
            // Validate password
            if (passwordEncoder.matches(user.getPassword(), doctor.getPassword())) {
                // Return user object without password (for security)
                System.out.println("The User Matches");
                return new Users(doctor.getEmail(), doctor.getPassword(), "ROLE_DOCTOR");
            }
            else{
                System.out.println("The password not matches");
            }
        }
//
//        // Check if the user is a patient
//        Optional<Patient> patientOpt = pRepo.findByEmail(user.getEmail());
//        if (patientOpt.isPresent()) {
//            Patient patient = patientOpt.get();
//            // Validate password
//            if (passwordEncoder.matches(user.getPassword(), patient.getPassword())) {
//                // Return user object without password (for security)
//                return new Users(patient.getEmail(), null, "PATIENT");
//            }
//        }

        // If no match for doctor or patient, return null or handle it
        return null;
    }
}

