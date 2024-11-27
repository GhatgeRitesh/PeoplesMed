package com.FrontEnd.Web_InterFace.FeignServices;


import com.FrontEnd.Web_InterFace.EntityManager.Mail.GMailEntity;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Doctor;
import com.FrontEnd.Web_InterFace.EntityManager.Users.MeetingDetails;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import jakarta.servlet.http.HttpSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient("FEATURES")
public interface FeaturesService {
    // in this class all the required methods from the other service are
    // interfaces are stored here and then the object is injected to required method
    // using the autowire and method from this classes are called
    // used into the computation
    @PostMapping("/MailService/RegisterDocMail")
    public Boolean RegisterDoctorMail(@RequestBody Doctor doctor);

    @PostMapping("/MailService/RegisterPatMail")
    public Boolean RegisterPatMail(@RequestBody Patient patient);

    @PostMapping("/MailService/MeetingDetailsMail")
    public Boolean MeetingDetailsMail(@RequestBody MeetingDetails meetingDetails);


}
