package com.FrontEnd.Web_InterFace.Controllers;

import com.FrontEnd.Web_InterFace.EntityManager.TestEntity;
import com.FrontEnd.Web_InterFace.FeignServices.DBinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/PeoplesMed")
public class Login {
    @Autowired
    @Qualifier("testEntity1")
    TestEntity testEntity;

    @Autowired
    DBinterface dBinterface;

    @GetMapping("/Login")
    public ModelAndView login(ModelAndView mv) {
        mv.addObject("Welcome", "Team");
        mv.setViewName("Login");
        return mv;
    }
    @PostMapping("/Login/Submit")
    public ModelAndView loginSubmission(@ModelAttribute TestEntity testEntity, ModelAndView mv){

        System.out.println(testEntity.getId()+" "+testEntity.getName()+" "+testEntity.getRole());
        if(dBinterface.checkUser(testEntity)){
            mv.addObject("Welcome","Admin");
        }
        mv.addObject("Welcome","User");
        mv.setViewName("Welcome");
        return mv;
    }
}
