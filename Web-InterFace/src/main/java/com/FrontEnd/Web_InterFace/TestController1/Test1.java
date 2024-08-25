package com.FrontEnd.Web_InterFace.TestController1;



import com.FrontEnd.Web_InterFace.FeignServices.FeaturesInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping("Web/")
public class Test1 {
    @Autowired
    FeaturesInterfaces featuresInterfaces;
    @GetMapping("/getData")
    public ArrayList<Integer> get(){
        return featuresInterfaces.test1();
    }
}
