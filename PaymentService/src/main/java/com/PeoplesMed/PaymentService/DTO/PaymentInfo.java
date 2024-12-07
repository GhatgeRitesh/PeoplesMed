package com.PeoplesMed.PaymentService.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Data
@Scope("prototype")
@Getter @Setter
public class PaymentInfo {
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;
}
