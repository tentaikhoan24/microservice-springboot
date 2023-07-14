/*
* Copyright(C) 2023 Luvina Software Company
* ApiGatewayApplication.java, July 14, 2023 dunghm
*/
package com.dunghm.apigateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
* Class main để chạy chương trình
* @author DungHM
*/
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
