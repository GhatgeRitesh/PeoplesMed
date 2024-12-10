package com.FrontEnd.CustomerService.Configurations;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Getter @Setter
@Data
public class currUser {
    private String Mail;
    private String Role;
    private String name;

}
