package com.db.empl.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeList")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer empNumber;
    private String name;
    private String department;
    private Integer salary;
}
