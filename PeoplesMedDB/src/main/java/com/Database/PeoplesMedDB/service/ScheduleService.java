package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Schedule;
import com.Database.PeoplesMedDB.Repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;

    public void SaveSchedule(Schedule schedule){
        scheduleRepo.save(schedule);
    }
    public List<Schedule> getScheduleById(Long D_id, String date) {
        List<Schedule> schedules = scheduleRepo.findByDoctorIdAndSlotDate(D_id, date);
        return schedules;
    }
}
