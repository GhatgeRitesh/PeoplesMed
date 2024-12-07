package com.PeoplesMed.PaymentService.DTO;


import lombok.*;
import org.springframework.context.annotation.Scope;

@Data
@Scope("prototype")
@Getter @Setter
public class StripeResponse {

    private String status;
    private String message;
    private String sessionId;
    private String sessionUrl;
}
