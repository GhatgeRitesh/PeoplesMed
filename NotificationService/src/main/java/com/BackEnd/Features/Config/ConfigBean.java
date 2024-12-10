package com.BackEnd.Features.Config;

import com.BackEnd.Features.Models.Patient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.BackEnd.Features.MailService.MeetingDetails;

@Configuration
public class ConfigBean {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Patient patient(){
        return new Patient();
    }

    @Bean
    public MeetingDetails meetingDetails(){
        return new MeetingDetails();
    }
}
