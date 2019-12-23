package com.example.demoemp.controller;

import com.example.demoemp.dto.EmployeeDTO;
import com.example.demoemp.service.DemoEmpService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findbyid/{id}")
    @ApiOperation(value = "findbyid", notes = "Endpoint for returning one Employee by id", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Id", value = "Employee Id, String, e.g.: firstname.lastname@company.com", required = true, dataType = "String")})
    public EmployeeDTO findById(@PathVariable String Id) {
        return demoEmpService.findById(Id);
    }
}

