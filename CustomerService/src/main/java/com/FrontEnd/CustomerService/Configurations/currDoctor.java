package com.FrontEnd.CustomerService.Configurations;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Data
@Getter @Setter
public class currDoctor {
    private String doctorName;
    private String doctorEmail;
    private Long doctorId;
}
