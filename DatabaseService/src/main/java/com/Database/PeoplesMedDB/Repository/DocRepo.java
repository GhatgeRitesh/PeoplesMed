package com.Database.PeoplesMedDB.Repository;

import com.Database.PeoplesMedDB.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocRepo extends JpaRepository<Doctor,Long> {
    // Custom Query Methods to find the users by email
    Doctor findByEmail(String email);


}
