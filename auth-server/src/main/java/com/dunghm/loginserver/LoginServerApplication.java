/*
* Copyright(C) 2023 Luvina Software Company
* LoginServerApplication.java, July 14, 2023 dunghm
*/
package com.dunghm.loginserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* Class application để chạy chương trình
* @author DungHM
*/
@SpringBootApplication
@EnableDiscoveryClient
public class LoginServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServerApplication.class, args);
	}

}
