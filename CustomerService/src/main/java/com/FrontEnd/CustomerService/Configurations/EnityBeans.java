package com.FrontEnd.CustomerService.Configurations;

import com.FrontEnd.CustomerService.EntityManager.PaymentEntity.PaymentInfo;
import com.FrontEnd.CustomerService.EntityManager.PaymentEntity.StripeResponse;
import com.FrontEnd.CustomerService.EntityManager.Users.Appointments;
import com.FrontEnd.CustomerService.EntityManager.Users.BookedSchedules;
import com.FrontEnd.CustomerService.EntityManager.Mail.MeetingDetails;
import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnityBeans {
    @Bean
    public currUser currUser(){
        return new currUser();
    }
    @Bean
    public Patient patient(){
        return new Patient();
    }

    @Bean
    public MeetingDetails meetingDetails(){
        return new MeetingDetails();
    }

    @Bean
    public PaymentInfo paymentInfo(){
        return new PaymentInfo();
    }

    @Bean
    public StripeResponse stripeResponse(){
        return new StripeResponse();
    }

    @Bean
    public Appointments appointments(){return new Appointments();}

    @Bean
    public BookedSchedules bookedSchedules(){return new BookedSchedules();}

    @Bean
    public currDoctor currDoctor(){return new currDoctor();}
}
