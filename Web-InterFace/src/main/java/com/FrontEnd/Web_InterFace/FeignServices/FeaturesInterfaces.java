package com.FrontEnd.Web_InterFace.FeignServices;


import com.FrontEnd.Web_InterFace.EntityManager.Mail.GMailEntity;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("FEATURES")
public interface FeaturesInterfaces {
    // in this class all the required methods from the other service are
    // interfaces are stored here and then the object is injected to required method
    // using the autowire and method from this classes are called
    // used into the computation
    @PostMapping("/F/SendMail")
    public boolean SendEmail(GMailEntity gMailEntity);

}
