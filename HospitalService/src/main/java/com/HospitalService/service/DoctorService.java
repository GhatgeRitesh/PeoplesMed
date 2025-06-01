package com.HospitalService.service;

import com.HospitalService.model.Doctor;
import com.HospitalService.repository.DoctorRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public List<Doctor> listDocs(){
        try{
            log.info("DoctorService Listing Doctors");
            List<Doctor> list= new ArrayList<>();
            list=doctorRepo.findAll();
            log.info("Result retrieved from repository "+list.toString());
            return list;
        }
        catch (JpaObjectRetrievalFailureException e) {
            log.info("Exception Observed while retrieving Doctor list ");
            return null;
        }
    }
}
