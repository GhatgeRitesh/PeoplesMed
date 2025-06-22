package com.HospitalService.repository;

import com.HospitalService.model.Emergency_Requests;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyRequestRepo extends JpaRepository<Emergency_Requests,Long> {

    List<Emergency_Requests> findByHospital_Id(Long hospitalId);
    @Modifying
    @Transactional
    @Query("UPDATE Emergency_Requests e SET e.acceptanceStatus = :status WHERE e.id = :requestId")
    int updateAcceptanceStatusById(@Param("requestId") Long requestId, @Param("status") String status);
}
