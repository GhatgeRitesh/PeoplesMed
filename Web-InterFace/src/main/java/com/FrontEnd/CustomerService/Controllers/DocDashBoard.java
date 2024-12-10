package com.FrontEnd.CustomerService.Controllers;

import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/D")
@Log
public class DocDashBoard {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/patientList")
    public ModelAndView patList(ModelAndView mv){
        log.info("Patient list retrival started");
        List<Patient> list = databaseService.getAllPatients();
        System.out.println("List :- " + list.toString());
        mv.addObject("list", list);
        mv.setViewName("DocDashBoard");
        if(list.isEmpty()){
            log.info(" The list is Empty :");
            mv.addObject("list","The recieved list is empty :");
            mv.setViewName("DocDashBoard");
        }
        System.out.println("List :- " + list.toString());
        mv.addObject("list", list);
        mv.setViewName("DocDashBoard");
        return mv;
    }
}
