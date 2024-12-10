package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Appointments;
import com.Database.PeoplesMedDB.Entity.BookedSchedules;
import com.Database.PeoplesMedDB.Repository.AppointmetsRepo;
import com.Database.PeoplesMedDB.Repository.BookedSchedulesRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class ScheduleService {

    @Autowired
    private AppointmetsRepo appointmetsRepo;

    @Autowired
    private BookedSchedulesRepo bookedSchedulesRepo;

    public void saveASchedule(Appointments appointments){
       appointmetsRepo.save(appointments);
//
    }

    public int updateASchedule(Long d_id, String time , String Date){
        appointmetsRepo.updateSchedule(d_id, time, Date);
        return 0;
    }

    public List<Appointments>  getASchedule(Long d_id , String Date){

        log.info("Service - fetch - started");
        List<Appointments> res = appointmetsRepo.getASchedule(d_id, Date);
        if(res.isEmpty()){
            log.info("service - fetch - complete - current - null - saving - new");
            Appointments appointments1 = new Appointments();
            appointments1.setDId(d_id);
            appointments1.setSlotDate(Date);
            appointments1.setSlotTime("09:00AM");
            appointments1.setLimit(0);
            appointmetsRepo.save(appointments1);

            Appointments appointments2 = new Appointments();
            appointments2.setDId(d_id);
            appointments2.setSlotDate(Date);
            appointments2.setSlotTime("10:00AM");
            appointments2.setLimit(0);
            appointmetsRepo.save(appointments2);

            Appointments appointments3 = new Appointments();
            appointments3.setDId(d_id);
            appointments3.setSlotDate(Date);
            appointments3.setSlotTime("11:00AM");
            appointments3.setLimit(0);
            appointmetsRepo.save(appointments3);

            Appointments appointments4 = new Appointments();
            appointments4.setDId(d_id);
            appointments4.setSlotDate(Date);
            appointments4.setSlotTime("01:00AM");
            appointments4.setLimit(0);
            appointmetsRepo.save(appointments4);

            Appointments appointments5 = new Appointments();
            appointments5.setDId(d_id);
            appointments5.setSlotDate(Date);
            appointments5.setSlotTime("02:00AM");
            appointments5.setLimit(0);
            appointmetsRepo.save(appointments5);

            Appointments appointments6 = new Appointments();
            appointments6.setDId(d_id);
            appointments6.setSlotDate(Date);
            appointments6.setSlotTime("03:00AM");
            appointments6.setLimit(0);
            appointmetsRepo.save(appointments6);

            log.info("service Fetch completed and appointment saved");
            return appointmetsRepo.getASchedule(d_id, Date);
        }
        log.info("Service Fetch completed existing appointments" + res.toString());
        return res;
    }

    public List<BookedSchedules> getBSchedulePatient(Long users_id){
        List<BookedSchedules> res = bookedSchedulesRepo.getBSchedulePatient(users_id);
        System.out.println(res.toString());
        return res;
    }
    public List<BookedSchedules> getBScheduleDoctor(Long users_id){
        List<BookedSchedules> res = bookedSchedulesRepo.getBScheduleDoctor(users_id);
        System.out.println(res.toString());
        return res;
    }
}
