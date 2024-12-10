package com.BackEnd.Features.MailService;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfigurations {

    @Value("mail.server.password")
    private String appkey;
    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); // Replace with your SMTP server
        mailSender.setPort(587); // Usually 587 for TLS, 465 for SSL
        mailSender.setUsername("riteshghatge5555@gmail.com"); // Replace with your email
        mailSender.setPassword("xchu jpes veot kyxt"); // Replace with your password

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true"); // Enable debugging logs if needed

        return mailSender;
    }
}
