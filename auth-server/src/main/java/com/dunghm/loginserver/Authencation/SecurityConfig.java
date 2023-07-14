/*
* Copyright(C) 2023 Luvina Software Company
* SecurityConfig.java, July 14, 2023 dunghm
*/
package com.dunghm.loginserver.Authencation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
* Tạo 1 lớp cáu hình để mã hoá password
* @author DungHM
*/
@Configuration
public class SecurityConfig {
    /**
     * Tạo bean với chức năng mã hoá password để xử dụng
     * @return : trả về 1 đối tượng của lớp
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
