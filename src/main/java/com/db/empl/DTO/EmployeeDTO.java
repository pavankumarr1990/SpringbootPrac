package com.db.empl.DTO;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer empNumber;
    private String name;
    private String department;
    private Integer salary;
}