package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Long> {

}
