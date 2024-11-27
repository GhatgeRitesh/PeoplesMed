package com.BackEnd.Features.MailService;

import com.BackEnd.Features.Models.Doctor;
import com.BackEnd.Features.Models.Patient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@RequestMapping("/MailService")
public class MailController {
   @Autowired
    private MailSenderService mailSenderService;

   @Autowired
   private Templates templates;

    @PostMapping("/RegisterDocMail")
    public Boolean RegisterDocMail(@RequestBody Doctor doc)  {
        String subject="Registration Confirmation Mail";
        try {
            mailSenderService.sendEmail(doc.getEmail(), subject, templates.RegisertDoc(doc));
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @PostMapping("/RegisterPatMail")
    public Boolean RegisterPatMail(@RequestBody Patient patient){
        String subject = "Registration Confirmation Mail";
        try{
            mailSenderService.sendEmail(patient.getEmail(),subject, templates.RegisterPatient(patient.getName()));
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @PostMapping("/MeetingDetailsMail")
    public Boolean MeetingDetailsMail(@RequestBody MeetingDetails meetingDetails){
        String subject="Appointment successfully Received and here are your Meeting Details";
        try{
            mailSenderService.sendEmail(meetingDetails.getMail(), subject, templates.MeetingDetailsMail(meetingDetails));
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }


}
