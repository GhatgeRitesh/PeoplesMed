package com.FrontEnd.Web_InterFace.Controllers;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Register")
@Log
public class RegisterControllers {
    @GetMapping("/D")
    public ModelAndView getDReg(ModelAndView mv){
        log.info("Doctor Register Form Display");
        mv.setViewName("DDsign");
        return mv;
    }
    @GetMapping("/P")
    public ModelAndView getPReg(ModelAndView mv) {
        log.info("Patient Registration Form Accessed");
        mv.setViewName("PPsign");
        return mv;
    }
}
