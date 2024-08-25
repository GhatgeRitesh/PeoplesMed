package com.Database.PeoplesMedDB.TestServices;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DB")
public class testService1 {
    // here the database operations should be done on an systematic url
    // it should return the data as json or ResponseBody type
    // most of the methods from this service will get to features and web interfaces
    // implement database services properly

    @GetMapping("/test1")
    public String test1(){
        return "OK-peoplesMed";
    }
}
