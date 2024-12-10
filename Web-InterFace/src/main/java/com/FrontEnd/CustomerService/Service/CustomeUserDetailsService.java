package com.FrontEnd.CustomerService.Service;

import com.FrontEnd.CustomerService.Configurations.Users;
import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    private DatabaseService databaseService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("LoadByUsername Method Started");
        Users user;
        try {
            // Here we only fetch user details (username and hashed password)
            user = databaseService.verifyUser(new Users(username, "dummyPassword")); // Replace with valid request object structure
            if (user == null || user.getUsername() == null) {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        } catch (Exception e) {
            System.out.println("Error while calling the DB service: " + e.getMessage());
            throw new UsernameNotFoundException("User not found with username: " + username, e);
        }
        System.out.println("User found: " + user.getUsername());

        // Build and return a Spring Security UserDetails object
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())  // Assume password is already hashed in DB
                .roles("ADMIN")  // Hardcoding roles for now, adjust this as needed
                .build();
    }
}

