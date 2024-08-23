package com.FrontEnd.Web_InterFace.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PageController {
     @GetMapping("welcome")
     public ModelAndView welcome(ModelAndView mv){
         mv.addObject("Name","Ritesh");
         mv.setViewName("Welcome");
         return mv;
     }
}
