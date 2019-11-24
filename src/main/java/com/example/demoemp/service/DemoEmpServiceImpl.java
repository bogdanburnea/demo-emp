package com.example.demoemp.service;

import com.example.demoemp.domain.Employee;
import com.example.demoemp.dto.EmployeeDTO;
import com.example.demoemp.dto.mapper.EmployeeMapper;
import com.example.demoemp.repository.DemoEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoEmpServiceImpl implements DemoEmpService {

    @Autowired
    private DemoEmpRepository demoEmpRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> findAll() {
        List<Employee> listEmployee = demoEmpRepository.findAll();
        List<EmployeeDTO> listEmployeeDTO = new ArrayList<>();
        listEmployee.stream().forEach(e -> {
            listEmployeeDTO.add(employeeMapper.toDTO(e));
        });
        return listEmployeeDTO;
    }
}
