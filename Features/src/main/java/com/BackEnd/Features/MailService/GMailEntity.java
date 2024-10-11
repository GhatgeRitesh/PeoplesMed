package com.BackEnd.Features.MailService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class GMailEntity {
   private String receiver;
   private String role;
   private String msg;
   private String subject;

    public GMailEntity(){}
    public GMailEntity(String receiver, String role, String msg,String subject){
        this.receiver=receiver;
        this.role=role;
        this.msg=msg;
        this.subject=subject;
    }

    @Override
    public String toString() {
        return "GMailEntity{" +
                "receiver='" + receiver + '\'' +
                ", role='" + role + '\'' +
                ", msg='" + msg + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
