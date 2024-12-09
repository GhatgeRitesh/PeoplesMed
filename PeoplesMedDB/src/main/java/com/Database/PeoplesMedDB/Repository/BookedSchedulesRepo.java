package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.BookedSchedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookedSchedulesRepo extends JpaRepository<BookedSchedules,Long> {

    @Query("SELECT b FROM BookedSchedules b WHERE b.pId = :p_id")
    List<BookedSchedules> getBSchedulePatient(@Param("p_id") Long p_id);

    @Query("SELECT b FROM BookedSchedules b WHERE b.dId = :d_id")
    List<BookedSchedules> getBScheduleDoctor(@Param("d_id") Long d_id);

}
