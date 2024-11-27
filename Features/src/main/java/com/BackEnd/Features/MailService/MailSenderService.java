package com.BackEnd.Features.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Log
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String message) throws MessagingException {
        // Create a MimeMessage
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        // Use MimeMessageHelper to set up the email
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom("riteshghatge5555@gmail.com"); // Replace with your email address
        helper.setText(message, true); // The 'true' flag indicates HTML content

        // Send the email
        mailSender.send(mimeMessage);
    }
}
