package com.sistema.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ApiCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCourseApplication.class, args);
	}

	
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
