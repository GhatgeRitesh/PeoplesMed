package com.FrontEnd.Web_InterFace.FeignServices;

import com.FrontEnd.Web_InterFace.Configurations.Users;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("PEOPLESMEDDB")
public interface UserClient {
    @PostMapping("/ValidateUser")
    public Users verifyUser(@RequestBody Users user);
    @PostMapping("/AddDoctor")
    public ResponseEntity<Doctor> AddDoc(@RequestBody Doctor doc);
    @PostMapping("/AddPatient")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient P);
    @PostMapping("/GetDocEntity")
    public Doctor getDoc(@RequestBody Doctor doc);
    @GetMapping("/getAllDocs")
    public List<Doctor> getAllDocs();
    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients();
    @PostMapping("/getPUser")
    public ResponseEntity<Patient> getUserProfile(String Email);
}
