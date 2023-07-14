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

@CrossOrigin
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
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
