package com.Database.PeoplesMedDB.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Users {
    private String email;
    private String password;
    private String role;

    public Users(String email, String password,String role) {
        this.email=email;
        this.password=password;
        this.role=role;
    }
}
