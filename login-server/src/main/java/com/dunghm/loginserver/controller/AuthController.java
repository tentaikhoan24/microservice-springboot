package com.dunghm.loginserver.controller;

import com.dunghm.loginserver.Service.PasswordService;
import com.dunghm.loginserver.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
public class AuthController {
    public static List<Account> list = new ArrayList<>() {{
        add(new Account(1, "admin", "$2a$10$3llKhHBDeHP9nD3zkDWFXevtH9Zv6Oi1LOaMny6OmaDlyeDGEcEti",
                "la@luvina.com"));
    }};
    public static Integer id = 1;
    @Autowired
    private PasswordService passwordService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        for (Account acc : list) {
            if (account.getUserName().equalsIgnoreCase(acc.getUserName())) {
                if (passwordService.matches(account.getPassword(), acc.getPassword())) {
                    return ResponseEntity.ok("Logged!!!");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account is not exits!!!");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        id ++;
        account.setId(id);
        list.add(account);
        String encodePassword = passwordService.encodePassword(account.getPassword());
        account.setPassword(encodePassword);
        return ResponseEntity.ok(account);
    }
}
