package com.example.MSAServiceB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaServiceB2Application {

	public static void main(String[] args) {
		SpringApplication.run(MsaServiceB2Application.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}
}
