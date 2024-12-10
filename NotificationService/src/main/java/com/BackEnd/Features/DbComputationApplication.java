package com.BackEnd.Features;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@Log
@EnableFeignClients
public class DbComputationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbComputationApplication.class, args);
	}
	// This is test comment;
}
