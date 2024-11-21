package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Schedule;
import com.Database.PeoplesMedDB.Repository.ScheduleRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return scheduleRepo.findSchedulesByDoctorIdAndDate(dId, date);
    }
}
