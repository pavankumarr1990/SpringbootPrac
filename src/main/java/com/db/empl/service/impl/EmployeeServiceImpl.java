package com.db.empl.service.impl;

import com.db.empl.DTO.EmployeeDTO;
import com.db.empl.entity.EmployeeEntity;
import com.db.empl.repo.EmployeeRepo;
import com.db.empl.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeRepo repo;

    @Override
    @Transactional
    public EmployeeDTO addEmployee(EmployeeDTO dto) {
        EmployeeEntity emp = new EmployeeEntity();
//        emp.setEmpNumber(dto.getEmpNumber());
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        repo.save(emp);
        return dto;
    }

    @Override
    public EmployeeDTO getByEmpNumber(int empNumber) {
        EmployeeEntity emp = repo.findByEmpNumber(empNumber)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return new EmployeeDTO(
                emp.getEmpNumber(),
                emp.getName(),
                emp.getDepartment(),
                emp.getSalary()
        );
    }
}
