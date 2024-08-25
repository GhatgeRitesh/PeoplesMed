package com.FrontEnd.Web_InterFace.FeignServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@FeignClient("FEATURES")
public interface DBInterfaces {
    // in this class all the required methods from the other service are
    // interfaces are stored here and then the object is injected to required method
    // using the autowire and method from this classes are called
    // used into the computation
    @GetMapping("/Features/Test1")
    public @ResponseBody ArrayList<Integer> test1();

}
