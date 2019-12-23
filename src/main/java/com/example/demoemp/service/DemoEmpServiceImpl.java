package com.example.demoemp.service;

import com.example.demoemp.dto.EmployeeDTO;
import com.example.demoemp.dto.mapper.EmployeeMapper;
import com.example.demoemp.repository.DemoEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoEmpServiceImpl implements DemoEmpService {

    @Autowired
    private DemoEmpRepository demoEmpRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> findAll() {
        return demoEmpRepository.findAll().stream().map(e -> {
            return employeeMapper.toDTO(e);
        }).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(String id) {
        return employeeMapper.toDTO(demoEmpRepository.findById(id).get());
    }
}
