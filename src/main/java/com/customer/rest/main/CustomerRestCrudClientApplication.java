package com.customer.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.customer.rest")
public class CustomerRestCrudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRestCrudClientApplication.class, args);
		
		
	}
}
