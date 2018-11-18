package com.spring.app.authapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.spring.app"},exclude = { SecurityAutoConfiguration.class })
public class AuthAppApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(AuthAppApplication.class, args);
		System.out.println("Hello app");
	}

}
