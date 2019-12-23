package com.example.demoemp.service;

import com.example.demoemp.dto.EmployeeDTO;

import java.util.List;

public interface DemoEmpService {
    public List<EmployeeDTO> findAll();

    EmployeeDTO findById(String id);
}
