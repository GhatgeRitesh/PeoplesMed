package com.FrontEnd.Web_InterFace.Configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component @Getter @Setter
public class currUser {
    private String Mail;
    private String Role;

    @Override
    public String toString() {
        return "currUser{" +
                "Mail='" + Mail + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
