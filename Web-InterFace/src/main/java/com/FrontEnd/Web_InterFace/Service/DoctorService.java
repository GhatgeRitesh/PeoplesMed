package com.FrontEnd.Web_InterFace.Service;


import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private UserClient userClient;

    @Cacheable(value = "doctorsCache" , key = "'allDoctors'")
    public List<Doctor> getCachedDocs(){
        return userClient.getAllDocs();
    }
}
