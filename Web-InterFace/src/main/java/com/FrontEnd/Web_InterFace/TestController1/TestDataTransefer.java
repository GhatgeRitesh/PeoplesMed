package com.FrontEnd.Web_InterFace.TestController1;

import com.FrontEnd.Web_InterFace.FeignServices.DBinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Web")
public class TestDataTransefer {
    @Autowired
    DBinterface dBinterface;

    @GetMapping("/db")
    public String dbtest(){
        return dBinterface.test1();
    }
}
