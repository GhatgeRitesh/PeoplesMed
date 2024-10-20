package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Doctor;
import com.Database.PeoplesMedDB.Repository.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocService {
    @Autowired
    private final DocRepo docRepo;

    public DocService(DocRepo docRepo){
        this.docRepo=docRepo;
    }

    public void save(Doctor doc) {
        docRepo.save(doc);
    }

    public List<Doctor> getAll(){
        List<Doctor> list=docRepo.findAll();
        return list;
    }

    public Doctor getDoctor(String email){
        Doctor validDoctor = docRepo.findByEmail(email);
        if(validDoctor != null) return validDoctor;
        return null;
    }
}
