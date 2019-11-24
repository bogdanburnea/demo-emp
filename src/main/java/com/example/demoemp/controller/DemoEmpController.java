package com.example.demoemp.controller;

import com.example.demoemp.domain.Employee;
import com.example.demoemp.dto.EmployeeDTO;
import com.example.demoemp.service.DemoEmpService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Bad Request. The server could not understand the request due to invalid document body."),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
public class DemoEmpController {

    @Autowired
    DemoEmpService demoEmpService;

    @GetMapping("/findall")
    @ApiOperation(value = "findall", notes = "Endpoint for returning all Employees", response = EmployeeDTO.class)
    public List<EmployeeDTO> findAll() {
        return demoEmpService.findAll();
    }
}

