package com.example.demoemp.dto;

import com.example.demoemp.dto.type.EmployeeDepartmentEnum;
import com.example.demoemp.dto.type.EmployeeJobEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotNull
    @Email
    private String empl_email;

    @NotNull
    private String empl_id;

    @NotNull
    private String empl_name;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String empl_date_of_birth;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String empl_date_of_hire;

    @NotNull
    private EmployeeJobEnum empl_job;

    @NotNull
    private EmployeeDepartmentEnum empl_department;
}
