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

    @GetMapping()
    public ModelAndView loginform(ModelAndView mv){
        log.info("Login Form Access");
        mv.setViewName("PLogin");
        return mv;
    }
    @GetMapping("/Failure")
    public ModelAndView failure(ModelAndView mv){
        mv.setViewName("loginFailure");
        return mv;
    }


}
