package com.Database.PeoplesMedDB.Controller;
import com.Database.PeoplesMedDB.Entity.Doctor;

import com.Database.PeoplesMedDB.Entity.Patient;
import com.Database.PeoplesMedDB.Entity.Users;
import com.Database.PeoplesMedDB.Repository.DocRepo;
import com.Database.PeoplesMedDB.Repository.PRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final PRepo pRepo;
    public Authenticator(DocRepo docRepo,PRepo pRepo){
        this.docRepo=docRepo;
        this.pRepo=pRepo;
    }

    @PostMapping("/ValidateUser")
    public Users verifyUser(@RequestBody Users user) {

        // check the user fields are correct or not
        if(user==null){
            log.info("the Login form data received empty");
            return null;
        }
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);
        // Check if the user is a doctor
        Optional<Doctor> doctorOpt = docRepo.findByEmail(user.getEmail());
        if (doctorOpt.isPresent()) {
            Doctor doctor = doctorOpt.get();
            // Validate password
            if (passwordEncoder.matches(user.getPassword(), doctor.getPassword())) {
                return new Users(doctor.getEmail(), doctor.getPassword(), "DOCTOR");
            }
        }

//        // Check if the user is a patient
//        //Optional<Patient> patientOpt = PRepo.findByEmail(user.getEmail());
//        if (patientOpt.isPresent()) {
//            Patient patient = patientOpt.get();
//            // Validate password
//            if (passwordEncoder.matches(user.getPassword(),user.getPassword())) {
//                return new Users(patient.getEmail(), patient.getPassword(), "PATIENT");
//            }
//        }


        // If the username or password don't match, return null or handle it with an exception
        return null;
    }
}
