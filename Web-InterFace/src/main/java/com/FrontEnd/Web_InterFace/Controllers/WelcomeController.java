package com.FrontEnd.Web_InterFace.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/PeoplesMed/")
public class WelcomeController {
    @GetMapping("/Home")
    public ModelAndView home(ModelAndView mv){
        // The code to retrive Reviews
        // code to add the attributes and views
        mv.addObject("Welcome","Team");
        mv.setViewName("Welcome");
        return mv;
    }
}
