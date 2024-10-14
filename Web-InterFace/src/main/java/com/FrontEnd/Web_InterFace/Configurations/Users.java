package com.FrontEnd.Web_InterFace.Configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class Users {
    private String username;
    private String password;

    // Default constructor
    public Users() {
    }

    // Constructor with parameters
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
