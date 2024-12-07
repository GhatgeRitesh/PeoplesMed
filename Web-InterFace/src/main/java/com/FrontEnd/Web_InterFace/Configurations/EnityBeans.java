package com.FrontEnd.Web_InterFace.Configurations;

import com.FrontEnd.Web_InterFace.EntityManager.PaymentEntity.PaymentInfo;
import com.FrontEnd.Web_InterFace.EntityManager.PaymentEntity.StripeResponse;
import com.FrontEnd.Web_InterFace.EntityManager.Users.MeetingDetails;
import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
import com.FrontEnd.Web_InterFace.EntityManager.Users.UpdateScheduleDTO;
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
    public  UpdateScheduleDTO updateScheduleDTO(){
        return new UpdateScheduleDTO();
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
}
