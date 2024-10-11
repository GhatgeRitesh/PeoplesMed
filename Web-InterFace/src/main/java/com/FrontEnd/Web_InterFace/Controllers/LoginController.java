package com.FrontEnd.Web_InterFace.Controllers;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@Log
public class LoginController {

    @GetMapping("/P")
    public ModelAndView getPlogin(ModelAndView mv){
        log.info("Patient Login Form Access");
        mv.setViewName("Patiant");
        return mv;
    }

    @GetMapping("/D")
    public ModelAndView getDoclogin(ModelAndView mv){
        log.info("Doctor Login Form Accessed");
        mv.setViewName("login");
        return mv;
    }
    @GetMapping("/A")
    public ModelAndView getAdminLogin(ModelAndView mv){
        log.info("Admin login intialized");
        mv.setViewName("/Admin");
        return mv;
    }
}
