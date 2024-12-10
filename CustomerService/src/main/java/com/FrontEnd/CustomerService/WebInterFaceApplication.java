package com.FrontEnd.CustomerService;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@Log
@EnableFeignClients
@EnableCaching
public class WebInterFaceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebInterFaceApplication.class, args);
	}
    @Override
	public void run(String...arg){
		log.info("The Web Interface Running Successfully");
	}
}
