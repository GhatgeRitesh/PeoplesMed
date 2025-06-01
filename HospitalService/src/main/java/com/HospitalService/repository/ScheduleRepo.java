package com.HospitalService.repository;

import com.HospitalService.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,Long> {
}
