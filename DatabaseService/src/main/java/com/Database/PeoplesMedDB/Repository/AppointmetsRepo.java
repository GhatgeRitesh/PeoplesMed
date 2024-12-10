package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.Appointments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmetsRepo extends JpaRepository<Appointments,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Appointments a SET a.Limit = a.Limit+1 " +
            "WHERE a.dId = :d_id AND a.slotTime = :time AND a.slotDate = :date")
    int updateSchedule(@Param("d_id") Long d_id,
                       @Param("time") String time,
                       @Param("date") String date);

    @Query("SELECT a FROM Appointments a WHERE a.dId = :d_id AND a.slotDate = :date")
    List<Appointments> getASchedule(@Param("d_id") Long d_id,
                                    @Param("date") String date);
}
