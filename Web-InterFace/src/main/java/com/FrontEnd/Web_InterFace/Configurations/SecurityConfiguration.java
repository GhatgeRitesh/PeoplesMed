package com.FrontEnd.Web_InterFace.Configurations;

import com.FrontEnd.Web_InterFace.FeignServices.UserClient;
import com.FrontEnd.Web_InterFace.Service.CustomeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

    @Autowired
    private CustomeUserDetailsService customeUserDetailsService;
    @Autowired
    private UserClient userClient;
    @Autowired
    private currUser currUser;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("Authentication Process Started");

        http.csrf(csrf -> csrf.disable());

        // Define role-based access to specific URLs
        http.authorizeHttpRequests(authz -> authz
                .requestMatchers("/D/**").hasAuthority("ROLE_DOCTOR") // Adjusted pattern to ** for more coverage
                .requestMatchers("/P/**").hasAuthority("ROLE_PATIENT")
                .anyRequest().permitAll()
        );

        http.formLogin(form -> form
                .loginPage("/login") // Custom login page
                .loginProcessingUrl("/loginform")
                .permitAll()
                .defaultSuccessUrl("/home/Profile", true)
                .failureUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
        );

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        System.out.println("Custom Authentication Provider Initiated");

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) {
                String username = authentication.getName();
                String rawPassword = authentication.getCredentials().toString();

                System.out.println("Authenticating user: " + username);

                Users user = userClient.verifyUser(new Users(username, rawPassword)); // Feign client validation

                if (user == null || user.getUsername() == null) {
                    throw new BadCredentialsException("Invalid username or password");
                }

                System.out.println("User authenticated: " + user.getUsername() + " with role: " + user.getRole());

                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                if (!encoder.matches(rawPassword, user.getPassword())) {
                    throw new BadCredentialsException("Invalid password");
                }

                // Create list of authorities
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.getRole())); // No extra "ROLE_" prefix
// Prefix role

                System.out.println("The authorities from authentication provider :" + authorities);
                currUser.setMail(user.getUsername());
                currUser.setRole(authorities.toString());

                // Return authenticated token
                return new UsernamePasswordAuthenticationToken(username, rawPassword, authorities);
            }
        };

        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setUserDetailsService(customeUserDetailsService);

        return provider;
    }
}

//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration{
//
//    @Autowired
//    private CustomeUserDetailsService customeUserDetailsService;
//    @Autowired
//    private UserClient userClient;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        System.out.println(" the Process of Authentication started");
//        http.csrf(customizer -> customizer.disable());
//        // Define role-based access to specific URLs
//        http.authorizeHttpRequests(authz -> authz
//                .requestMatchers("/D/*").hasRole("DOCTOR") // Only users with "DOCTOR" role can access /D/*
//                .requestMatchers("/P/*").hasRole("PATIENT") // Only users with "PATIENT" role can access /P/*
//                .anyRequest().permitAll() // Other URLs are accessible by anyone
//        );
////        http.formLogin(Customizer.withDefaults());
////         Configure custom login page
//        http.formLogin(form -> form
//                .loginPage("/login/D") // Specify the custom login page URL
//                .loginProcessingUrl("/loginform") // URL to submit the login form
//                .permitAll() // Allow all to access the login page
//                .defaultSuccessUrl("/home/Welcome", true) // Redirect to home after successful login
//                .failureUrl("/login/Failure") // Redirect to login with error on failure
//                .usernameParameter("email") // Optional: specify the username parameter
//                .passwordParameter("password") // Optional: specify the password parameter
//        );
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        System.out.println("Authentication Provider Initiated process");
//
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider() {
//            @Override
//            public Authentication authenticate(Authentication authentication) {
//                String username = authentication.getName();
//                String rawPassword = authentication.getCredentials().toString();
//
//                Users user = userClient.verifyUser(new Users(username, rawPassword)); // Verify user via Feign
//
//                if (user == null || user.getUsername() == null) {
//                    throw new BadCredentialsException("Invalid username or password");
//                }
//
//                System.out.println(user.getPassword() + " " + user.getUsername() + " " + user.getRole() );
//                // Validate password
//                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//                if (!encoder.matches(rawPassword, user.getPassword())) {
//                    throw new BadCredentialsException("Invalid password");
//                }
//
//                // Create a list of granted authorities (roles)
//                List<GrantedAuthority> authorities = new ArrayList<>();
//                authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole())); // Ensure the role is prefixed with 'ROLE_'
//
//                // Return the authenticated token with roles
//                return new UsernamePasswordAuthenticationToken(username, rawPassword, authorities);
//            }
//        };
//
//        provider.setPasswordEncoder(new BCryptPasswordEncoder()); // Password encoder
//        provider.setUserDetailsService(customeUserDetailsService); // Set the user details service
//
//        return provider;
//    }