package com.EmergencyServcice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmergencyServciceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmergencyServciceApplication.class, args);
	}

}
