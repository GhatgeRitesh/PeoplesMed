package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Schedule;
import com.Database.PeoplesMedDB.Repository.ScheduleRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    public void saveSchedule(Schedule schedule){
        scheduleRepo.save(schedule);
    }

    public List<Schedule> getSchedule(Long dId, String date) {

        System.out.println( scheduleRepo.findSchedulesByDoctorIdAndDate(dId, date).toString());
        return new ArrayList<>();
    }

    public List<Schedule> getPSchedule(Long p_id){
        System.out.println("pservice activated");
//        List<Schedule> res= scheduleRepo.findSchedulesByPatientId(p_id);
        System.out.println("pservice completed");
        return new ArrayList<>();
    }
}
