package com.example.demoemp.dto.mapper;

import com.example.demoemp.domain.Employee;
import com.example.demoemp.dto.EmployeeDTO;
import com.example.demoemp.dto.type.EmployeeDepartmentEnum;
import com.example.demoemp.dto.type.EmployeeJobEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmployeeMapper {

    public Employee fromDTO(EmployeeDTO dto) {
        return Employee.builder().empl_id(dto.getEmpl_id()).empl_name(dto.getEmpl_name()).empl_job(dto.getEmpl_job().toString()).empl_department(dto.getEmpl_department().toString())
                .empl_date_of_birth(dto.getEmpl_date_of_birth()).empl_date_of_hire(dto.getEmpl_date_of_hire()).last_updated_at(LocalDateTime.now()).last_updated_by("current_user").build();
    }

    public EmployeeDTO toDTO(Employee employee) {
        return EmployeeDTO.builder().empl_id(employee.getEmpl_id()).empl_name(employee.getEmpl_name()).empl_job(EmployeeJobEnum.valueOf(employee.getEmpl_job())).empl_department(EmployeeDepartmentEnum.valueOf(employee.getEmpl_department()))
                .empl_date_of_birth(employee.getEmpl_date_of_birth()).empl_date_of_hire(employee.getEmpl_date_of_hire()).build();
    }
}
