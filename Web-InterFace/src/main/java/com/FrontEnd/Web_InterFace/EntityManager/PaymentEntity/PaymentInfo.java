package com.FrontEnd.Web_InterFace.EntityManager.PaymentEntity;

import lombok.*;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;
}
