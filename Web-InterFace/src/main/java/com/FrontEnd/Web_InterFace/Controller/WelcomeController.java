package com.FrontEnd.Web_InterFace.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {
     @GetMapping("home")
     public String homecontroller(){
         return "Hello World";
     }
}
