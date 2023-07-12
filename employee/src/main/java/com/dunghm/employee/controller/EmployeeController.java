package com.dunghm.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @GetMapping()
    public ResponseEntity<?> getListEmployee() {
        return ResponseEntity.ok(new String("Employee service ok!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showDetailEmployee(@PathVariable String id) {
        try {
            Long idEmployee = Long.parseLong(id);
            if (id.equalsIgnoreCase("1")) {
                return ResponseEntity.ok(new String("detail"));
            }
            return ResponseEntity.ok(new String("no detail"));
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String("Bad!!"));
        }
    }
}
