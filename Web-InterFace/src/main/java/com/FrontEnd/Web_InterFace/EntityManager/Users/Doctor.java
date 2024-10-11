package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter @Setter
public class Doctor {
    private Long docId;
    private String name;
    private String email;
    private String contact;
    private String registerNo;
    private String city;
    private String hospitalName;
    private String address;
    private String password;

    public Doctor(){}


    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", register_no='" + registerNo + '\'' +
                ", city='" + city + '\'' +
                ", hospital_name='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
