package com.HospitalService.repository;

import com.HospitalService.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospital, Long> {
}
