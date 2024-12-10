package com.FrontEnd.CustomerService.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter @Setter
public class Doctor {
    private Long D_id;
    private String name;
    private String email;
    private String contact;
    private String registerNo;
    private String city;
    private String hospitalName;
    private String password;
    private String role;
    private String education;
    private String specialization;
    private String experience;

    public Doctor(){}

    @Override
    public String toString() {
        return "Doctor{" +
                "D_id=" + D_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", registerNo='" + registerNo + '\'' +
                ", city='" + city + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", education='" + education + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
