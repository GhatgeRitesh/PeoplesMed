package com.FrontEnd.Web_InterFace.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class LoginController {
    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv){
        mv.setViewName("login1");
        return mv;
    }
    @GetMapping("/Doctor")
    public ModelAndView doc(ModelAndView mv){
        mv.setViewName("Doctor");
        return mv;
    }
    @GetMapping("/sign")
    public ModelAndView sign(ModelAndView mv){
        mv.setViewName("Doctor");
        return mv;
    }
    @GetMapping("/patient")
    public ModelAndView patient(ModelAndView mv){
        mv.setViewName("Patiant");
        return mv;
    }
}
