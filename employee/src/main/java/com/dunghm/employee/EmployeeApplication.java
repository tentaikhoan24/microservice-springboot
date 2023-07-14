/*
* Copyright(C) 2023 Luvina Software Company
* EmployeeApplication.java, July 14, 2023 dunghm
*/
package com.dunghm.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* Class main để chạy chương trình
* @author DungHM
*/
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
