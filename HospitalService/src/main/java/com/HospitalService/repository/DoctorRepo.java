package com.HospitalService.repository;

import com.HospitalService.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {

}
