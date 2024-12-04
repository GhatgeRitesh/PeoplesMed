package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.Schedule;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Transactional
    @Modifying
    @Query("UPDATE Schedule s SET s.description = :desc, s.pId = :p_id, s.Limit = s.Limit+1 " +
            "WHERE s.dId = :d_id AND s.slotTime = :time AND s.slotDate = :date")
    int updateSchedule(@Param("d_id") Long d_id,
                       @Param("p_id") Long p_id,
                       @Param("desc") String desc,
                       @Param("time") String time,
                       @Param("date") String date);

    @Query("SELECT s FROM Schedule s WHERE s.dId = :d_id")
    List<Schedule> getDSchedulebyId(@Param("d_id") Long d_id);


}
