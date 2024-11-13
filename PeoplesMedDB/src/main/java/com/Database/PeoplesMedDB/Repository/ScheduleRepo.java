package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.Schedule;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Long> {

    // Using Spring Data JPA method naming conventions
    List<Schedule> findByDoctorIdAndSlotDate(Long doctorId, String slotDate);

    // Alternatively, using a custom query
    @Query("SELECT s FROM Schedule s WHERE s.doctorId = :doctorId AND s.slotDate = :slotDate")
    List<Schedule> findSchedulesByDoctorIdAndDate(@Param("doctorId") Long doctorId, @Param("slotDate") String slotDate);
}
