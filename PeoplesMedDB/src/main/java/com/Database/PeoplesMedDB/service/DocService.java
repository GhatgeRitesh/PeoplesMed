package com.Database.PeoplesMedDB.service;

import com.Database.PeoplesMedDB.Entity.Doctor;
import com.Database.PeoplesMedDB.Repository.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}