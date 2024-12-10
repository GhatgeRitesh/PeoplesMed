package com.FrontEnd.CustomerService.FeignServices;


import com.FrontEnd.CustomerService.EntityManager.Users.Doctor;
import com.FrontEnd.CustomerService.EntityManager.Mail.MeetingDetails;
import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("FEATURES")
public interface MailService {
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
