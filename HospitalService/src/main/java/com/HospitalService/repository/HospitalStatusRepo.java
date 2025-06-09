package com.HospitalService.repository;

import com.HospitalService.model.HospitalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HospitalStatusRepo extends JpaRepository<HospitalStatus, Long> {

        // Finds status by the hospital's ID
        @Query("SELECT hs FROM HospitalStatus hs WHERE hs.hospital.id = :hospitalId")
        HospitalStatus findByHospitalId(@Param("hospitalId") Long hospitalId);

}
