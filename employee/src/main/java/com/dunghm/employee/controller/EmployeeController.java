package com.dunghm.employee.controller;

import com.dunghm.employee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController {

    public static List<Employee> list = new ArrayList<>() {{
        add(new Employee(1, "Đen Vâu", 34, "https://cdn.tuoitrethudo.com.vn/stores/news_dataimages/phamthanhtrung/062021/05/15/0934_3.jpg?rt=20210605152000", "Quảng Ninh", "Rapper"));
        add(new Employee(2, "Messi", 36, "https://assets.goal.com/v3/assets/bltcc7a7ffd2fbf71f5/blt12dbddde5342ce4c/648866ff21a8556da61fa167/GOAL_-_Blank_WEB_-_Facebook_-_2023-06-13T135350.847.png?auto=webp&format=pjpg&width=3840&quality=60", "Arghentina", "Cầu thủ"));
        add(new Employee(3, "Faker", 28, "https://upload.wikimedia.org/wikipedia/commons/1/1a/Faker_2020_interview.jpg", "Hàn Quốc", "Gamer"));
    }};
    public static Integer id = 3;
    @GetMapping()
    public ResponseEntity<List<Employee>> getListEmployee() {
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showDetailEmployee(@PathVariable String id) {
        try {
            Integer idEmployee = Integer.parseInt(id);
            for (Employee emp : list) {
                if (emp.getId() == idEmployee) {
                    return ResponseEntity.ok(emp);
                }
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID is not exist");
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String("Bad request"));
        }
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody Employee employee) {
        try {
            if (employee.getId() != null) {
                for (Employee emp : list) {
                    if (emp.getId() == employee.getId()) {
                        emp.setAddress(employee.getAddress());
                        emp.setAge(employee.getAge());
                        emp.setImage(employee.getImage());
                        emp.setJob(employee.getJob());
                        emp.setName(employee.getName());
                        return ResponseEntity.ok(list);
                    }
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id is not exist");
            } else {
                id ++;
                employee.setId(id);
                list.add(employee);
                return ResponseEntity.ok(list);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            for (Employee employee : list) {
                if (employee.getId() == Integer.parseInt(id)) {
                    list.remove(employee);
                    return ResponseEntity.ok(list);
                }
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id is not exist");
        } catch (NumberFormatException nfe) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id is not valid");
        }
    }
}
