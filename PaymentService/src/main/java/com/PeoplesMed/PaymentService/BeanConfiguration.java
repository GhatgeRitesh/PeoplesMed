package com.PeoplesMed.PaymentService;

import com.PeoplesMed.PaymentService.DTO.PaymentInfo;
import com.PeoplesMed.PaymentService.DTO.StripeResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PaymentInfo paymentInfo(){
        return new PaymentInfo();
    }

    @Bean
    public StripeResponse stripeResponse(){
        return new StripeResponse();
    }
}
