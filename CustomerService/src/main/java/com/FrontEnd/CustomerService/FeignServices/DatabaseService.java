package com.FrontEnd.CustomerService.FeignServices;

import com.FrontEnd.CustomerService.Configurations.Users;
import com.FrontEnd.CustomerService.EntityManager.Users.Appointments;
import com.FrontEnd.CustomerService.EntityManager.Users.BookedSchedules;
import com.FrontEnd.CustomerService.EntityManager.Users.Doctor;
import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("PEOPLESMEDDB")
public interface DatabaseService {
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

    @PostMapping("/saveBookedSchedule")
    public void saveSchedule(@RequestBody BookedSchedules bookedSchedules);

    @PostMapping("/updateASchedule")
    public int updateASchedule(@RequestBody BookedSchedules bookedSchedules);

    @PostMapping("/getBSchedulePatient")
    public List<BookedSchedules> getBSchedulePatient(Long p_Id);

    @PostMapping("/getBScheduleDoctor")
    public List<BookedSchedules> getBScheduleDoctor(Long d_Id);
}
