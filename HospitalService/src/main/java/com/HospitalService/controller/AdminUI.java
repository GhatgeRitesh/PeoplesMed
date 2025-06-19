package com.HospitalService.controller;

import com.HospitalService.model.Emergency_Requests;
import com.HospitalService.model.Hospital;
import com.HospitalService.repository.EmergencyRequestRepo;
import com.HospitalService.repository.HospitalRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@Log
@RequestMapping("/Admin")
public class AdminUI {
    @Autowired
    private HospitalRepo hr;

    @Autowired
    private EmergencyRequestRepo emergencyRequestRepo;

    @GetMapping("/List_Hospitals")
    public ModelAndView getHospitals(ModelAndView mv){
        log.info("Api Hit Successfully");
        List<Hospital> hospitalList = hr.findAll();
        log.info("hospitals list retrieved successfully" + hospitalList.toString());
        mv.addObject("Hospital", hospitalList);
        mv.setViewName("Admin_hospital_list");
        return mv;
    }

    @GetMapping("/ListEmergencyRequest")
    public ModelAndView getRequests(ModelAndView mv){
        log.info("Retrieving Emergency Request till now from database");
        List<Emergency_Requests> requests= emergencyRequestRepo.findAll();
        mv.addObject("requests", requests);
        mv.setViewName("EmergencyRequestsAdmin");
        return mv;
    }
}
