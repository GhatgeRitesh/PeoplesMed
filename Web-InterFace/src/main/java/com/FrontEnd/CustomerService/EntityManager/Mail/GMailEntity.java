package com.FrontEnd.CustomerService.EntityManager.Mail;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


// this pojo can also been used as DTO
@Component
@Getter @Setter
public class GMailEntity {
    private String receiver;
    private String role;
    private String msg;
    private String subject;

    public GMailEntity(){}
    public GMailEntity(String receiver,String role,String msg , String subject){
        this.receiver=receiver;
        this.role=role;
        this.msg=msg;
        this.subject=subject;
    }

    @Override
    public String toString() {
        return "GMailEntity{" +
                "to='" + receiver + '\'' +
                ", from='" + role + '\'' +
                ", msg='" + msg + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
