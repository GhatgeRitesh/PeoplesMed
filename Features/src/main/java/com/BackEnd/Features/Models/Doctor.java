package com.BackEnd.Features.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter @Setter
public class Doctor {
    private String name;
    private String email;
    private String specialization;

    public Doctor(){}
    public Doctor(String name,String email,String specialization){
        this.name=name;
        this.email=email;
        this.specialization=specialization;
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Specialization='" + specialization + '\'' +
                '}';
    }
}
