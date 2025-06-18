package com.EmergencyServcice.Model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {
    @Bean
    public E_ID e_id(){
        return new E_ID();
    }
}
