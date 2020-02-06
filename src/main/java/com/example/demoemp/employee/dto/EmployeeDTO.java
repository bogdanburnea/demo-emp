package com.example.demoemp.employee.dto;

import com.example.demoemp.employee.dto.type.EmployeeDepartmentEnum;
import com.example.demoemp.employee.dto.type.EmployeeJobEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotNull
    private String emplId;

    @NotNull
    private String emplName;

    @NotNull
    @Email
    private String emplEmail;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String emplDateOfBirth;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String emplHireDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String emplLeaveDate;

    @NotNull
    private EmployeeJobEnum emplJob;

    @NotNull
    private EmployeeDepartmentEnum emplDepartment;
}
