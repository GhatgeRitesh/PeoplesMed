package com.FrontEnd.CustomerService.Service;


import com.FrontEnd.CustomerService.EntityManager.Users.Doctor;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DatabaseService databaseService;

    @Cacheable(value = "doctorsCache" , key = "'allDoctors'")
    public List<Doctor> getCachedDocs(){
        return databaseService.getAllDocs();
    }


}
