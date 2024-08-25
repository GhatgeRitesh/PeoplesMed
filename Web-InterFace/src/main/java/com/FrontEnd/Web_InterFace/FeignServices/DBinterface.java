package com.FrontEnd.Web_InterFace.FeignServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PEOPLESMEDDB")
public interface DBinterface {
    @GetMapping("/DB/test1")
    public String test1();

}
