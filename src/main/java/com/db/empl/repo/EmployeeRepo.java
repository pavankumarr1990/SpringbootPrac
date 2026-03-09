package com.db.empl.repo;

import com.db.empl.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmployeeRepo  extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByEmpNumber(int empNumber);


    @Transactional
    @Modifying
    @Query(value = "Delete from EmployeeList where empNumber = ?1 and name = ?2", nativeQuery = true)
    int deleteByEmpNumberAndName(int empNumber, String name);

    @Transactional
    @Modifying
    @Query(value = "update EmployeeList set name = ?1, department = ?2, salary = ?3 where empNumber = ?4", nativeQuery = true)
    int updateByEmpNumber(int empNumber, String name);
}
