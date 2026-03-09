package com.db.empl.controller;

import com.db.empl.DTO.EmployeeDTO;
import com.db.empl.constants.MessageConstant;
import com.db.empl.exception.InternalServerException;
import com.db.empl.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {
    //    @Autowired
    private final EmployeeService service;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO dto) {
        try {
            return ResponseEntity.ok(service.addEmployee(dto));
        } catch (Exception e) {
            LOGGER.error("Error in adding employee", e);
            throw new InternalServerException(e.getMessage());
        }
    }

    @GetMapping("/{empNumber}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int empNumber) {
        return ResponseEntity.ok(service.getByEmpNumber(empNumber));
    }

    @DeleteMapping("/delete/{empNumber}/{name}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int empNumber, @PathVariable String name) {
        service.deleteByEmpNumber(empNumber, name);
        return ResponseEntity.ok().build();
    }
}
