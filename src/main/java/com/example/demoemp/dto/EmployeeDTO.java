package com.example.demoemp.dto;

import com.example.demoemp.dto.type.EmployeeDepartmentEnum;
import com.example.demoemp.dto.type.EmployeeJobEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotNull
    private String empl_id;

    @NotNull
    private String empl_name;

    @NotNull
    private LocalDateTime empl_date_of_birth;

    @NotNull
    private LocalDateTime empl_date_of_hire;

    @NotNull
    private EmployeeJobEnum empl_job;

    @NotNull
    private EmployeeDepartmentEnum empl_department;
}
