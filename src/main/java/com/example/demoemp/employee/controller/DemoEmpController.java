package com.example.demoemp.employee.controller;

import com.example.demoemp.employee.dto.EmployeeDTO;
import com.example.demoemp.employee.service.DemoEmpService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/get-all-employees")
    @ApiOperation(value = "getAllEmployees", notes = "Endpoint for returning all Employees", response = EmployeeDTO.class)
    public List<EmployeeDTO> getAllEmployees() {
        return demoEmpService.findAll();
    }

    @GetMapping("/get-employee-by-email/{email}")
    @ApiOperation(value = "getEmployeeByEmail", notes = "Endpoint for returning one Employee by email", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "Employee email, String, e.g.: firstname.lastname@company.com", required = true, dataType = "String")})
    public EmployeeDTO getEmployeeByEmail(@PathVariable String email) {
        return demoEmpService.findById(email);
    }

    @GetMapping("/get-employee-by-dept/{dept}")
    @ApiOperation(value = "getEmployeeByDept", notes = "Endpoint for returning one Employee by department", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dept", value = "Employee department, one of the following values: ADMIN, HR, FIN, SALES, IT, PROD", required = true, dataType = "String")})
    public List<EmployeeDTO> getEmployeeByDept(@PathVariable String dept) {
        return demoEmpService.findByDept(dept);
    }

    @PostMapping("/create-employee/{email}")
    @ApiOperation(value = "createEmployee", notes = "Endpoint for adding a Employee", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "Employee Email, String, e.g.: firstname.lastname@company.com", required = true, dataType = "String")})
    public EmployeeDTO createEmployee(@PathVariable String email, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return demoEmpService.save(email, employeeDTO);
    }

    @PutMapping("/update-employee/{email}")
    @ApiOperation(value = "updateEmployee", notes = "Endpoint for updating a Employee", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "Employee Email, String, e.g.: firstname.lastname@company.com", required = true, dataType = "String")})
    public EmployeeDTO updateEmployee(@PathVariable String email, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return demoEmpService.save(email, employeeDTO);
    }

    @DeleteMapping("/delete-employee-by-email/{email}")
    @ApiOperation(value = "deleteEmployeeByEmail", notes = "Endpoint for deleting a Employee by email", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "Employee Email, String, e.g.: firstname.lastname@company.com", required = true, dataType = "String")})
    public void deleteEmployeeByEmail(@PathVariable String email) {
        demoEmpService.deleteEmployeeByEmail(email);
    }

}

