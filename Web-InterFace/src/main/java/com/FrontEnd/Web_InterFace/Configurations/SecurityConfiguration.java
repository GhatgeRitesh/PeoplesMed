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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Autowired
    private CustomeUserDetailsService customeUserDetailsService;
    @Autowired
    private UserClient userClient;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        System.out.println("The Error");
        http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests(authz -> authz.requestMatchers("/D/*","/P/*").authenticated()
                .anyRequest().permitAll());
//        http.formLogin(Customizer.withDefaults());
//         Configure custom login page
        http.formLogin(form -> form
                .loginPage("/login/D") // Specify the custom login page URL
                .loginProcessingUrl("/loginform") // URL to submit the login form
                .permitAll() // Allow all to access the login page
                .defaultSuccessUrl("/home", true) // Redirect to home after successful login
                .failureUrl("/login/Failure") // Redirect to login with error on failure
                .usernameParameter("email") // Optional: specify the username parameter
                .passwordParameter("password") // Optional: specify the password parameter
        );
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        System.out.println("Authentication Provider Intiated process");
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) {
                String username = authentication.getName();
                String rawPassword = authentication.getCredentials().toString(); // Get the password from the login form

                Users user = userClient.verifyUser(new Users(username, rawPassword)); // Pass both username and password

                if (user == null || user.getUsername() == null) {
                    throw new BadCredentialsException("Invalid username or password");
                }

                // Validate the password
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                if (!encoder.matches(rawPassword, user.getPassword())) {
                    throw new BadCredentialsException("Invalid password");
                }

                return new UsernamePasswordAuthenticationToken(username, rawPassword, new ArrayList<>()); // Return authenticated token
            }
        };
        provider.setPasswordEncoder(new BCryptPasswordEncoder()); // Encoder for password validation
        provider.setUserDetailsService(customeUserDetailsService);
        return provider;
    }
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http.csrf(customizer -> customizer.disable()) // Disabling CSRF for simplicity
//            .authorizeHttpRequests(authz -> authz
//                    .requestMatchers("/home/Doctor", "/home/Patient").authenticated() // Permit access to these URLs
//                    .anyRequest().permitAll() // Require authentication for all other URLs
//            )
//            .formLogin(Customizer.withDefaults()); // Use default login form
//    return http.build();
//}
}
