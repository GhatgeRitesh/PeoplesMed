package com.FrontEnd.Web_InterFace.FeignServices;

import com.FrontEnd.Web_InterFace.Configurations.Users;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Schedule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

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


    @PostMapping("/SetSchedule")
    public ResponseEntity<?> setSchedule(Schedule schedule);
}
