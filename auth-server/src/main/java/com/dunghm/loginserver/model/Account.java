/*
* Copyright(C) 2023 Luvina Software Company
* Account.java, July 14, 2023 dunghm
*/
package com.dunghm.loginserver.model;

import jakarta.persistence.*;
import lombok.Data;

/**
* Tạo đối tượng entity tương ứng với 1 bảng trong database
* @author DungHM
*/
@Entity
@Table(name = "accounts")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "user_name", columnDefinition = "VARCHAR(255)")
    private String userName;
    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;
    @Column(name = "email", columnDefinition = "VARCHAR(255)")
    private String email;

    public Account() {
    }

    public Account(Long id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
