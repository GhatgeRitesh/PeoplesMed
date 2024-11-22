package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ScheduleRepo  extends JpaRepository<Schedule,Long> {
    @Query("SELECT s FROM Schedule s WHERE s.dId = :dId AND s.slotDate = :slotDate")
    List<Schedule> findSchedulesByDoctorIdAndDate(@Param("dId") Long doctorId, @Param("slotDate") String slotDate);

//    @Query("SELECT s FROM Schedule s WHERE s.patientid = :pId")
//    List<Schedule> findSchedulesByPatientId(@Param("pId") Long pId);

}
