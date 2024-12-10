package com.BackEnd.Features.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter @Setter
public class Patient {
    private Long p_id;
    private String name;
    private String gender;
    private String age;
    private String contact;
    private String email;
    private String address;
    private String city;
    private String password;
    private String role;


    @Override
    public String toString() {
        return "Patient{" +
                "p_id=" + p_id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
