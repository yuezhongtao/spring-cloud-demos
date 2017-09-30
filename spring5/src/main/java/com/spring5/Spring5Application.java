package com.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Spring5Application {

	public static void main(String[] args) {
		System.out.println("-------------test----------");
		SpringApplication.run(Spring5Application.class, args);
	}
}
