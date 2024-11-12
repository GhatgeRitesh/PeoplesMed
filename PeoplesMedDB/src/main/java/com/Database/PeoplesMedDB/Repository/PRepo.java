package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PRepo extends JpaRepository<Patient,Long> {
    Patient  findByEmail(String email);
}
