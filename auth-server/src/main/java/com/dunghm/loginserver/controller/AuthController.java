/*
* Copyright(C) 2023 Luvina Software Company
* AuthController.java, July 14, 2023 dunghm
*/
package com.dunghm.loginserver.controller;
import com.dunghm.loginserver.Service.AuthService;
import com.dunghm.loginserver.Service.PasswordService;
import com.dunghm.loginserver.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Tạo các api endpoint
* @author DungHM
*/
@CrossOrigin
@Controller
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private PasswordService passwordService;

    /**
     * Tạo chức năng đăng nhập
     * @param account : dữ liệu account từ người dùng
     * @return : trả về trạng thái đăng nhập
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        try {
            List<Account> list = authService.getList();
            for (Account acc : list) {
                if (account.getUserName().equalsIgnoreCase(acc.getUserName())) {
                    if (passwordService.matches(account.getPassword(), acc.getPassword())) {
                        Map<String, Object> response = new HashMap<>();
                        response.put("code", "200");
                        response.put("message","Logged!!!");
                        return ResponseEntity.ok(response);
                    }
                }
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account is not exits!!!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("System error!!!");
        }
    }

    /**
     * Lưu account vào database
     * @param account : dữ liệu từ người dùng cần lưu vào database
     * @return : trả về trạng thái sau khi thực hiện hành vi lưu vào database
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        try {
            String endCodePassword = passwordService.encodePassword(account.getPassword());
            account.setPassword(endCodePassword);
            authService.register(account);
            Map<String, Object> response = new HashMap<>();
            response.put("code", "200");
            response.put("message","Sign Up Success");
            response.put("New account", account);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("System error!!!");
        }
    }

}
