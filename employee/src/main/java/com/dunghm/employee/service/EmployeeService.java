/*
* Copyright(C) 2023 Luvina Software Company
* EmployeeService.java, July 14, 2023 dunghm
*/
package com.dunghm.employee.service;

import com.dunghm.employee.model.Employee;
import com.dunghm.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* Tạo service triển khai các phương thức thao tác với database
* @author DungHM
*/
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Lấy tất cả các bản ghi trong database
     * @return : List các bản ghi trong database
     */
    public List<Employee> getList() {
        return employeeRepository.findAll();
    }

    /**
     * Lưu đối tượng employee vào database
     * @param employee : dữ liệu từ người dùng
     */
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    /**
     * Xoá bản ghi trong database theo id
     * @param id : id của bản ghi từ người dùng
     */
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    /**
     * Lấy ra 1 bản ghi theo id
     * @param id : id của bản ghi từ người dùng
     * @return : lấy ra 1 bản ghi theo id được trả về dưới dạng đối tượng employee
     */
    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }
}
