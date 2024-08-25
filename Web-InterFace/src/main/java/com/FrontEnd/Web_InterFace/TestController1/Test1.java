package com.FrontEnd.Web_InterFace.TestController1;


import com.FrontEnd.Web_InterFace.FeignServices.DBInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("Web/")
public class Test1 {
    @Autowired
    DBInterfaces dbInterfaces;
    @GetMapping("/getData")
    public ArrayList<Integer> get(){
        return dbInterfaces.test1();
    }
}
