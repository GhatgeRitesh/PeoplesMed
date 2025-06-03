package com.HospitalService.repository;

import com.HospitalService.model.Emergency_Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyRequestRepo extends JpaRepository<Emergency_Requests,Long> {
}
