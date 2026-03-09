package com.db.empl.service;

import com.db.empl.DTO.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO dto);

    EmployeeDTO getByEmpNumber(int empNumber);
}