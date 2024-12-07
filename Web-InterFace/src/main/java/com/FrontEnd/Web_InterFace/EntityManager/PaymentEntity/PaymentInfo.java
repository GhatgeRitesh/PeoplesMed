package com.FrontEnd.Web_InterFace.EntityManager.PaymentEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Data
@Getter @Setter
public class PaymentInfo {
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;
}
