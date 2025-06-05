package com.HospitalService.repository;

import com.HospitalService.model.Hospital;
import com.HospitalService.model.HospitalStatusDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HospitalRepo extends JpaRepository<Hospital, Long> {
    @Query("SELECT new com.HospitalService.model.HospitalStatusDTO(" +
            "h.name, h.address, h.city, h.type, h.speciality, h.contact, " +
            "hs.icuAvailable, hs.otActive, " +
            "CASE WHEN hs.status = 'open' THEN true ELSE false END, " +
            "hs.presentDoctor, hs.staffCount, hs.ambulanceCount) " +
            "FROM Hospital h JOIN HospitalStatus hs ON h.id = hs.hospital.id " +
            "WHERE h.city = :city")
    List<HospitalStatusDTO> findHospitalStatusByCity(String city);

    Optional<Hospital> findByNameAndContact(String name, String contact);
}
