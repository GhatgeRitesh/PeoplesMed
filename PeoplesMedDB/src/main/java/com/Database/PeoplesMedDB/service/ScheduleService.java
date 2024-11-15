package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Schedule;
import com.Database.PeoplesMedDB.Repository.ScheduleRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;

    public void SaveSchedule(Schedule schedule){
        scheduleRepo.save(schedule);
    }
    public ResponseEntity<List<Schedule>> getAllSchedules(Long doctorId, String date){
       try {
           log.info("Fetching Schedules schedule service");
           List<Schedule> schedules=scheduleRepo.findByDoctorIdAndSlotDate(doctorId, date);
           System.out.println(schedules.toString());
           log.info(" Schedules schedule service successful");
           return new ResponseEntity<>(schedules, HttpStatus.OK);
       }catch(Exception e){
           log.info("Error while fetching schedules");
           return new ResponseEntity<>(null , HttpStatus.EXPECTATION_FAILED);
       }
    }

    public void updateSchedule(Long doctorId, String slotTime, String slotDate, String reason, String name, String email, Long patientId,Schedule.Status currstatus ){
       int res= scheduleRepo.updateSchedule(doctorId,slotTime,slotDate,reason,name,email,patientId,currstatus);
       if(res == 0) System.out.println("Data Not Present in table");
    }
}
