package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Schedule;
import com.Database.PeoplesMedDB.Repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;

    public void SaveSchedule(Schedule schedule){
        scheduleRepo.save(schedule);
    }
}
