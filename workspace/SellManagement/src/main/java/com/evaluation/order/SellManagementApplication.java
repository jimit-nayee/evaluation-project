package com.evaluation.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SellManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellManagementApplication.class, args);
	}

}
