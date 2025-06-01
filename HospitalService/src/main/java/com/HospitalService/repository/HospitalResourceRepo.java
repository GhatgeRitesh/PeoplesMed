package com.HospitalService.repository;

import com.HospitalService.model.HospitalResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalResourceRepo extends JpaRepository<HospitalResource,Long> {
}
