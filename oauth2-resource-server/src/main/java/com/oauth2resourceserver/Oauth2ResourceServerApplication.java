package com.oauth2resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Oauth2ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ResourceServerApplication.class, args);
	}
}
