package com.FrontEnd.Web_InterFace.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/Welcome")
    public ModelAndView home(ModelAndView mv){
        mv.setViewName("Welcome");
        return mv;
    }

}
