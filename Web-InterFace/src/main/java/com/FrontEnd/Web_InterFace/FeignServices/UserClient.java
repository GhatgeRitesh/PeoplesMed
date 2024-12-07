package com.FrontEnd.Web_InterFace.FeignServices;

import com.FrontEnd.Web_InterFace.Configurations.Users;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Appointments;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Patient> getPatientProfile(String Email);

    @PostMapping("/GetDoctor")
    public ResponseEntity<Doctor> getDoctorProfile(String Email);

    @PostMapping("/getASchedule")
    public List<Appointments> getAschedule(@RequestParam Long d_id,@RequestParam String Date);


}
