package com.HospitalService.repository;

import com.HospitalService.model.Emergency_Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyRequestRepo extends JpaRepository<Emergency_Requests,Long> {

    List<Emergency_Requests> findByHospital_Id(Long hospitalId);

}
