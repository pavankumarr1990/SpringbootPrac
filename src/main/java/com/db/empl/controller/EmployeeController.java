package com.db.empl.controller;

import com.db.empl.DTO.EmployeeDTO;
import com.db.empl.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.addEmployee(dto));
    }

    @GetMapping("/{empNumber}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int empNumber) {
        return ResponseEntity.ok(service.getByEmpNumber(empNumber));
    }
}
