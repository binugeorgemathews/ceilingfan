package com.wipro.springboot.fandemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
@EnableAspectJAutoProxy 
public class FandemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FandemoApplication.class, args);
		
	}

	
}
