package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Appointments;
import com.Database.PeoplesMedDB.Entity.BookedSchedules;
import com.Database.PeoplesMedDB.Entity.Schedule;
import com.Database.PeoplesMedDB.Repository.AppointmetsRepo;
import com.Database.PeoplesMedDB.Repository.BookedSchedulesRepo;
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

    @Autowired
    private AppointmetsRepo appointmetsRepo;

    @Autowired
    private BookedSchedulesRepo bookedSchedulesRepo;

    public void saveSchedule(Schedule schedule){
        scheduleRepo.save(schedule);
    }

    public List<Schedule> getSchedule(Long dId, String date) {
        return scheduleRepo.findSchedulesByDoctorIdAndDate(dId, date);
    }

    public List<Schedule> getPSchedule(Long p_id){
        System.out.println("pservice activated");
//        List<Schedule> res= scheduleRepo.findSchedulesByPatientId(p_id);
        System.out.println("pservice completed");
        return new ArrayList<>();
    }

    public void saveASchedule(){
//        Appointments appointments1 = new Appointments();
//        appointments1.setDId(2L);
//        appointments1.setSlotDate("2024-12-04");
//        appointments1.setSlotTime("10:00AM");
//        appointments1.setLimit(0);
//        appointmetsRepo.save(appointments1);

    }

    public int updateASchedule(){
//        appointmetsRepo.updateSchedule(1L,"09:00AM","2024-12-04");
        return 0;
    }

    public List<Appointments>  getASchedule(){
        List<Appointments> res = appointmetsRepo.getASchedule(1L,"2024-12-04");
        System.out.println(res.toString());
        return res;
    }

    public List<BookedSchedules> getBSchedule(){
        List<BookedSchedules> res = bookedSchedulesRepo.getBSchedule(2L);
        System.out.println(res.toString());
        return res;
    }
}
