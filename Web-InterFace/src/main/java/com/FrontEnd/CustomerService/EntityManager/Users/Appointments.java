package com.FrontEnd.CustomerService.EntityManager.Users;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Data
@Scope("prototype")
@Getter @Setter
public class Appointments {
    private Long aId;
    private Long dId;
    private String slotDate;
    private int Limit;
    private String slotTime;
}
