package com.example.MSAAPIGateWay;

import com.example.MSAAPIGateWay.filter.PostZuulFilter;
import com.example.MSAAPIGateWay.filter.PreZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class MsaApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaApiGateWayApplication.class, args);
	}

	@Bean
	public PreZuulFilter preZuulFilter() {
		return new PreZuulFilter();
	}

	@Bean
	public PostZuulFilter postZuulFilter() {
		return new PostZuulFilter();
	}
}
