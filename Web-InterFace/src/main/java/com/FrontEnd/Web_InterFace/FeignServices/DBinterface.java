package com.FrontEnd.Web_InterFace.FeignServices;

import com.FrontEnd.Web_InterFace.EntityManager.TestEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PEOPLESMEDDB")
public interface DBinterface {
    @GetMapping("/DB/test1")
    public String test1();
    @PostMapping("/PeoplesMed/Check")
    public Boolean checkUser(@RequestBody TestEntity newTestEntity);
}
