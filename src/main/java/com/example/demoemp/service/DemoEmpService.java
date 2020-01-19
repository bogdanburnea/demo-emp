package com.example.demoemp.service;

import com.example.demoemp.dto.EmployeeDTO;
import com.example.demoemp.dto.mapper.EmployeeMapper;
import com.example.demoemp.repository.DemoEmpRepository;
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
        return demoEmpRepository.findAll().stream().map(e -> {
            return employeeMapper.toDTO(e);
        }).collect(Collectors.toList());
    }

    public EmployeeDTO findById(String id) {
        return employeeMapper.toDTO(demoEmpRepository.findById(id).get());
    }

    public EmployeeDTO save(String email, EmployeeDTO employeeDTO) {
        if (email.equalsIgnoreCase(employeeDTO.getEmpl_email())) {
            return employeeMapper.toDTO(demoEmpRepository.save(employeeMapper.fromDTO(employeeDTO)));
        }
        return null;
    }

    public void deleteEmployeeByEmail(String email) {
        demoEmpRepository.deleteEmployee(email);
    }

    public List<EmployeeDTO> findByDept(String dept) {
        return demoEmpRepository.findAllByDept(dept).stream().map(e -> {
            return employeeMapper.toDTO(e);
        }).collect(Collectors.toList());
    }
}
