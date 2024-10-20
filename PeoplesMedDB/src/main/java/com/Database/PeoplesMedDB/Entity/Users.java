package com.Database.PeoplesMedDB.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Users {
    private String username;
    private String password;
    private String role;

    public Users(String username, String password,String role) {
        this.username=username;
        this.password=password;
        this.role=role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
