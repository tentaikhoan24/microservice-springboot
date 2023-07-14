/*
* Copyright(C) 2023 Luvina Software Company
* EmployeeController.java, July 14, 2023 dunghm
*/
package com.dunghm.employee.controller;

import com.dunghm.employee.model.Employee;
import com.dunghm.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Tạo ra các endpoint api cho dự án
* @author DungHM
*/
@CrossOrigin
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * Lấy ra tất cả các bản ghi trong database
     * @return : lấy ra tất cả các bản ghi dưới dạng List
     */
    @GetMapping()
    public ResponseEntity<?> getListEmployee() {
        try {
            List<Employee> list = employeeService.getList();
            Map<String, Object> response = new HashMap<>();
            response.put("code", "200");
            response.put("employees",list);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> responseError500 = new HashMap<>();
            responseError500.put("code", "500");
            responseError500.put("message","System error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseError500);
        }
    }

    /**
     * Lấy ra bản ghi theo id
     * @param id : id của bản ghi từ người dùng
     * @return : trả về bản ghi dưới dạng đối tượng employee và mã code, message
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> showDetailEmployee(@PathVariable String id) {
        try {
            Employee employee = employeeService.getById(Long.parseLong(id));
            Map<String, Object> response = new HashMap<>();
            response.put("code", "200");
            response.put("employee",employee);
            return ResponseEntity.ok(response);
        } catch (NumberFormatException e) {
            Map<String, Object> responseError = new HashMap<>();
            responseError.put("code", "400");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
        } catch (Exception e) {
            Map<String, Object> responseError500 = new HashMap<>();
            responseError500.put("code", "500");
            responseError500.put("message","System error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseError500);
        }
    }

    /**
     * Lưu dữ liệu từ người dùng dươi dạng employee vào database
     * @param employee : dữ liệu từ người dùng dưới dạng đối tượng employee
     * @return : mã code sau khi lưu và kèm theo đối tượng đó nếu lưu thành công
     */
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody Employee employee) {
        try {
            employeeService.save(employee);
            Map<String, Object> response = new HashMap<>();
            response.put("code", "200");
            response.put("message","Added");
            response.put("employee", employee);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> responseError500 = new HashMap<>();
            responseError500.put("code", "500");
            responseError500.put("message","System error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseError500);
        }
    }

    /**
     * Xoá 1 đối bản ghi trong database theo id
     * @param id : id của bản ghi từ người dùng
     * @return : trả về tất cả bản ghi và mã code nếu thành công
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            employeeService.delete(Long.parseLong(id));
            Map<String, Object> response = new HashMap<>();
            response.put("code", "200");
            response.put("message","Deleted");
            response.put("employees", employeeService.getList());
            return ResponseEntity.ok(response);
        } catch (NumberFormatException nfe) {
            Map<String, Object> responseError = new HashMap<>();
            responseError.put("code", "400");
            responseError.put("message", "Id is not valid");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
        } catch (Exception e) {
            Map<String, Object> responseError500 = new HashMap<>();
            responseError500.put("code", "500");
            responseError500.put("message","System error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseError500);
        }
    }
}
