package com.dunghm.loginserver.Service;

import com.dunghm.loginserver.model.Account;
import com.dunghm.loginserver.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;

    public void register(Account account) {
        authRepository.save(account);
    }

    public Account getById(Long id) {
        return authRepository.findById(id).get();
    }

    public List<Account> getList() {
        return authRepository.findAll();
    }
}
