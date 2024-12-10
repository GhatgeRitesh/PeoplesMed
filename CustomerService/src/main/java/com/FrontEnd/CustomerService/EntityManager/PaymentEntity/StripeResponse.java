package com.FrontEnd.CustomerService.EntityManager.PaymentEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Data
@Getter @Setter
public class StripeResponse {
    private String status;
    private String message;
    private String sessionId;
    private String sessionUrl;
}
