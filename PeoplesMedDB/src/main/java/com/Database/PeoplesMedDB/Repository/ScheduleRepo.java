package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.Schedule;
import feign.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Long> {

    // Using Spring Data JPA method naming conventions
    List<Schedule> findByDoctorIdAndSlotDate(Long doctorId, String slotDate);

    // Alternatively, using a custom query
    @Query("SELECT s FROM Schedule s WHERE s.doctorId = :doctorId AND s.slotDate = :slotDate")
    List<Schedule> findSchedulesByDoctorIdAndDate(@Param("doctorId") Long doctorId, @Param("slotDate") String slotDate);

    @Modifying
    @Transactional
    @Query("UPDATE doc_schedules s SET s.reason = :reason, s.name = :name, " +
            "s.email = :email, s.patientId = :patientId, s.currstatus = :currstatus " +
            "WHERE s.doctorId = :doctorId AND s.slotTime = :slotTime AND s.slotDate = :slotDate")
    int updateSchedule(
            @Param("doctorId") Long doctorId,
            @Param("slotTime") String slotTime,
            @Param("slotDate") String slotDate,
            @Param("reason") String reason,
            @Param("name") String name,
            @Param("email") String email,
            @Param("patientId") Long patientId,
            @Param("currstatus") Schedule.Status currstatus
    );

}
