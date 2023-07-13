package com.dunghm.loginserver.repository;

import com.dunghm.loginserver.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Account, Long> {
}
