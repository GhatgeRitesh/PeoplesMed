package com.FrontEnd.Web_InterFace.EntityManager.Users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter @Setter
public class Patient {
    private Long patId;
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
                "patId=" + patId +
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
