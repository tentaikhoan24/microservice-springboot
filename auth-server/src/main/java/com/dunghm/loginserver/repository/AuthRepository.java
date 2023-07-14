/*
* Copyright(C) 2023 Luvina Software Company
* AuthRepository.java, July 14, 2023 dunghm
*/
package com.dunghm.loginserver.repository;

import com.dunghm.loginserver.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* Tạo đối tượng kết thừa các phương thức từ JpaRepository để thao tác với database
* @author DungHM
*/
@Repository
public interface AuthRepository extends JpaRepository<Account, Long> {
}
