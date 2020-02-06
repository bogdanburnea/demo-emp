package com.example.demoemp.employee.service;

import com.example.demoemp.employee.dto.EmployeeDTO;
import com.example.demoemp.employee.dto.mapper.EmployeeMapper;
import com.example.demoemp.employee.dto.type.EmployeeDepartmentEnum;
import com.example.demoemp.employee.repository.DemoEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoEmpService {

    @Autowired
    private DemoEmpRepository demoEmpRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> findAll() {
        return demoEmpRepository.findAll().stream().filter(e ->
                e.getEmpl_leave_date() == null
        ).map(e -> {
            return employeeMapper.toDTO(e);
        }).collect(Collectors.toList());
    }

    public EmployeeDTO findById(String id) {
        return employeeMapper.toDTO(demoEmpRepository.findById(id).get());
    }

    public EmployeeDTO save(String id, EmployeeDTO employeeDTO) {
        if (id.equalsIgnoreCase(employeeDTO.getEmplId())) {
            return employeeMapper.toDTO(demoEmpRepository.save(employeeMapper.fromDTO(employeeDTO)));
        }
        return null;
    }

    public void deleteEmployeeById(String id) {
        demoEmpRepository.deleteEmployee(id);
    }

    public List<EmployeeDTO> findByDept(String dept) {
        return demoEmpRepository.findAllByDept(dept).stream().filter(e ->
                e.getEmpl_leave_date() == null
        ).map(e -> {
            return employeeMapper.toDTO(e);
        }).collect(Collectors.toList());
    }

    public EmployeeDTO employeeLeave(String id, String leaveDate) {
        EmployeeDTO employeeDTO = employeeMapper.toDTO(demoEmpRepository.findById(id).get());
        if (employeeDTO.getEmplLeaveDate() == null) {
            employeeDTO.setEmplLeaveDate(leaveDate);
        }
        return employeeMapper.toDTO(demoEmpRepository.save(employeeMapper.fromDTO(employeeDTO)));
    }

    public EmployeeDTO moveEmployeeDept(String id, String dept) {
        EmployeeDTO employeeDTO = employeeMapper.toDTO(demoEmpRepository.findById(id).get());
        EmployeeDepartmentEnum employeeDepartment = EmployeeDepartmentEnum.valueOf(dept);
        if ((!employeeDTO.getEmplDepartment().equals(employeeDepartment))
                && (employeeDTO.getEmplLeaveDate() != null)) {
            employeeDTO.setEmplDepartment(employeeDepartment);
        }
        return employeeMapper.toDTO(demoEmpRepository.save(employeeMapper.fromDTO(employeeDTO)));
    }

    public List<EmployeeDTO> findAllLeaveEmployee() {
        return demoEmpRepository.findAll().stream().filter(e ->
                e.getEmpl_leave_date() != null
        ).map(e -> {
            return employeeMapper.toDTO(e);
        }).collect(Collectors.toList());
    }
}
