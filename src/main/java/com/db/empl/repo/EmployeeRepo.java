package com.db.empl.repo;

import com.db.empl.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo  extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByEmpNumber(int empNumber);
}
