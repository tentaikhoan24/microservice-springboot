/*
* Copyright(C) 2023 Luvina Software Company
* PasswordService.java, July 14, 2023 dunghm
*/
package com.dunghm.loginserver.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/**
* Tạo service triển khai các phương thức mã hoá và giải mã mật khẩu
* @author DungHM
*/
@Service
public class PasswordService {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Phương thức mã hoá mật khẩu
     * @param password : mật khẩu từ người dùng
     * @return : trả về mật khẩu sau khi đã mã hoá
     */
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    /**
     * Kiểm tra mật khẩu từ người dùng với mât khẩu đã mã hoá trong database
     * @param rawPassword : mật khẩu từ người dùng
     * @param encodedPassword : mật khẩu đã mã hoá
     * @return : trả về kết quả sau khi so sánh dạng boolean
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
