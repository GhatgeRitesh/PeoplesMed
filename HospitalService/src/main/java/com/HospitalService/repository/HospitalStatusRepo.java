package com.HospitalService.repository;

import com.HospitalService.model.HospitalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalStatusRepo extends JpaRepository<HospitalStatus, Long> {

}
