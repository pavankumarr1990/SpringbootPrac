package com.db.empl.service.impl;

import com.db.empl.DTO.EmployeeDTO;
import com.db.empl.constants.MessageConstant;
import com.db.empl.entity.EmployeeEntity;
import com.db.empl.exception.InternalServerException;
import com.db.empl.repo.EmployeeRepo;
import com.db.empl.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeRepo repo;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Override
    @Transactional
    public EmployeeDTO addEmployee(EmployeeDTO dto) {
        try {
            EmployeeEntity emp = new EmployeeEntity();
//        emp.setEmpNumber(dto.getEmpNumber());
            emp.setName(dto.getName());
            emp.setDepartment(dto.getDepartment());
            emp.setSalary(dto.getSalary());
            repo.save(emp);
            return dto;
        } catch (Exception e) {
            throw new InternalServerException(MessageConstant.ERROR_IN_ADDING_EMPLOYEE);
        }
    }

    @Override
    public EmployeeDTO getByEmpNumber(int empNumber) {
        try {
            EmployeeEntity emp = repo.findByEmpNumber(empNumber)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            return new EmployeeDTO(
                    emp.getEmpNumber(),
                    emp.getName(),
                    emp.getDepartment(),
                    emp.getSalary()
            );
        } catch (RuntimeException e) {
            throw new InternalServerException(MessageConstant.ERROR_IN_FETCHING_EMPLOYEE);
        }
    }

    @Override
    public void deleteByEmpNumber(int empNumber, String name) {
        try {
            int rowsDeleted= repo.deleteByEmpNumberAndName(empNumber, name);
            if(rowsDeleted == 0) {
                throw new RuntimeException("No employee found with empNumber: " + empNumber + " and name: " + name);
            }
        } catch (Exception e) {
            LOGGER.error(MessageConstant.ERROR_IN_DELETING_EMPLOYEE, e);
            throw new InternalServerException(MessageConstant.ERROR_IN_DELETING_EMPLOYEE);
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO dto) {
        try {
            int rowsUpdated = repo.updateByEmpNumber(dto.getEmpNumber(), dto.getName());
            if (rowsUpdated == 0) {
                throw new RuntimeException("No employee found with empNumber: " + dto.getEmpNumber());
            }
        } catch (Exception e) {
            LOGGER.error(MessageConstant.ERROR_IN_UPDATING_EMPLOYEE, e);
            throw new InternalServerException(MessageConstant.ERROR_IN_UPDATING_EMPLOYEE);
        }
    }
}
