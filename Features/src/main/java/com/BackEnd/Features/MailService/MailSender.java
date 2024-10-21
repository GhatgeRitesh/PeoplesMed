package com.BackEnd.Features.MailService;

import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMultipart;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Properties;

@Component
@Log
@RestController
@RequestMapping("/F")
public class MailSender {
    @Autowired
    private Templates mail;

    @Value("${mail.server.password}")
    private String appkey;

    @PostMapping("/SendMail")
    public Boolean SendEmail(@RequestBody GMailEntity gMailEntity) {

        log.info("Mail Service Activated");

        // check the body is empty or not
        if (gMailEntity == null) {
            log.info("Entity is Empty terminating process");
            return false;
        }
       log.info(""+gMailEntity.toString());
        // Setting Attributes
        StringBuilder sub=new StringBuilder();
        if(Objects.equals(gMailEntity.getSubject(), "Register")){
            System.out.println("subject is register");
            sub.append("Thank You for Registering on PeoplesMed.pvt");
        } else if (gMailEntity.getSubject()=="Link") {
            sub.append("Oppointment Link With Patient");
        }

        StringBuilder mes=new StringBuilder();
        if(gMailEntity.getRole().equals("Doc")){
            System.out.println("message set for doc");
            mes.append(mail.RegisertDoc());
        }
        if(gMailEntity.getRole().equals("Pat")){
            System.out.println("message set for pat");
            mes.append(mail.RegisterPatient());
        }




        //SMTP Server details
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.host", "smtp.gmail.com");

        // Account and App password
        String username = "riteshghatge5555";
        String password = appkey;
        String from = "riteshghatge5555@gmail.com";

        //session coding creating session to Gmail API
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        //MimeMessage Code to develop matter of the Email
        try {
            Message msg = new MimeMessage(session);
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(gMailEntity.getReceiver()));
            msg.setFrom(new InternetAddress(from));
            msg.setSubject(sub.toString());

            MimeBodyPart mssg = new MimeBodyPart();

            mssg.setContent(mes.toString(), "text/html");

            // Attach the images to the mail using MimeBodyPart() and add it to the Multipart Object
//            MimeBodyPart image = new MimeBodyPart();
//            image.attachFile("D:/WebPages/drive_Clone/images/profile.png");
//            image.setContentID("<image1>");

            Multipart m = new MimeMultipart();
            m.addBodyPart(mssg);
//            m.addBodyPart(image);

            msg.setContent(m);
            Transport.send(msg);

            log.info("Mail Sent Successfully Mail Service Shutting down");
        } catch (Exception e) {
            log.info(" " + e);
        }
        return false;
    }

}








