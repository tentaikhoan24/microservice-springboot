/*
* Copyright(C) 2023 Luvina Software Company
* EmployeeRepository.java, July 14, 2023 dunghm
*/
package com.dunghm.employee.repository;

import com.dunghm.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* Tạo đối tượng để kế thừa các phương thức của JpaRepository để thao tác với database
* @author DungHM
*/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
