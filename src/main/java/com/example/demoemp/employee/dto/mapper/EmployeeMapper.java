package com.example.demoemp.employee.dto.mapper;

import com.example.demoemp.employee.dto.EmployeeDTO;
import com.example.demoemp.employee.dto.type.EmployeeDepartmentEnum;
import com.example.demoemp.employee.dto.type.EmployeeJobEnum;
import com.example.demoemp.employee.entity.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class EmployeeMapper {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Employee fromDTO(EmployeeDTO dto) {

        return Employee.builder()
                .empl_id(dto.getEmplId())
                .empl_name(dto.getEmplName())
                .empl_email(dto.getEmplEmail())
                .empl_date_of_birth(LocalDate.parse(dto.getEmplDateOfBirth(), dateTimeFormatter))
                .empl_hire_date(LocalDate.parse(dto.getEmplHireDate(), dateTimeFormatter))
                .empl_leave_date((dto.getEmplLeaveDate() == null) ? null : LocalDate.parse(dto.getEmplLeaveDate(), dateTimeFormatter))
                .empl_job(dto.getEmplJob().toString())
                .empl_department(dto.getEmplDepartment().toString())
                .last_updated_at(LocalDateTime.now())
                .last_updated_by("current_app_user")
                .build();
    }

    public EmployeeDTO toDTO(Employee employee) {
        return EmployeeDTO.builder()
                .emplId(employee.getEmpl_id())
                .emplName(employee.getEmpl_name())
                .emplEmail(employee.getEmpl_email())
                .emplDateOfBirth(employee.getEmpl_date_of_birth().toString())
                .emplHireDate(employee.getEmpl_hire_date().toString())
                .emplLeaveDate((employee.getEmpl_leave_date() == null) ? null : employee.getEmpl_leave_date().toString())
                .emplJob(EmployeeJobEnum.valueOf(employee.getEmpl_job()))
                .emplDepartment(EmployeeDepartmentEnum.valueOf(employee.getEmpl_department()))
                .build();
    }
}
