package com.example.demoemp.employee.controller;

import com.example.demoemp.employee.dto.EmployeeDTO;
import com.example.demoemp.employee.service.DemoEmpService;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Api(value = "demo-emp", description = "Endpoint providing API's for various operations with employee entity.")
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

    @GetMapping("/get-all-leave-employees")
    @ApiOperation(value = "getAllLeaveEmployees", notes = "Endpoint for returning all leave Employees", response = EmployeeDTO.class)
    public List<EmployeeDTO> getAllLeaveEmployees() {
        return demoEmpService.findAllLeaveEmployee();
    }

    @GetMapping("/get-employee-by-id/{id}")
    @ApiOperation(value = "getEmployeeById", notes = "Endpoint for returning one Employee by Id", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Employee id, String", required = true, dataType = "String")})
    public EmployeeDTO getEmployeeById(@PathVariable String id) {
        return demoEmpService.findById(id);
    }

    @GetMapping("/get-employee-by-dept/{dept}")
    @ApiOperation(value = "getEmployeeByDept", notes = "Endpoint for returning one Employee by department", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dept", value = "Employee department, one of the following values: ADMIN, HR, FIN, SALES, IT, PROD", required = true, dataType = "String")})
    public List<EmployeeDTO> getEmployeeByDept(@PathVariable String dept) {
        return demoEmpService.findByDept(dept);
    }

    @PostMapping("/hire-employee/{id}")
    @ApiOperation(value = "hireEmployee", notes = "Endpoint for adding a Employee", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Employee Id, String", required = true, dataType = "String")})
    public EmployeeDTO hireEmployee(@PathVariable String id, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return demoEmpService.save(id, employeeDTO);
    }

    @PostMapping("/employeeLeave/{id}/{leaveDate}")
    @ApiOperation(value = "employeeLeave", notes = "Endpoint for employee leave", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Employee Id, String", required = true, dataType = "String"),
            @ApiImplicitParam(name = "leaveDate", value = "Date of employee leaving, yyyy-MM-dd format", required = true, dataType = "String")})
    public EmployeeDTO employeeLeave(@PathVariable String id, @PathVariable @JsonFormat(pattern = "yyyy-MM-dd") String leaveDate) {
        return demoEmpService.employeeLeave(id, leaveDate);
    }

    @PostMapping("/moveEmployeeDept/{id}/{dept}")
    @ApiOperation(value = "moveEmployeeDept", notes = "Endpoint for moving an employee to a new department", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Employee Id, String", required = true, dataType = "String"),
            @ApiImplicitParam(name = "dept", value = "Employee department, one of the following values: ADMIN, HR, FIN, SALES, IT, PROD", required = true, dataType = "String")
    })
    public EmployeeDTO moveEmployeeDept(@PathVariable String id, @PathVariable String dept) {
        return demoEmpService.moveEmployeeDept(id, dept);
    }

    @PutMapping("/update-employee/{id}")
    @ApiOperation(value = "updateEmployee", notes = "Endpoint for updating a Employee", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Employee Id, String", required = true, dataType = "String")})
    public EmployeeDTO updateEmployee(@PathVariable String id, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return demoEmpService.save(id, employeeDTO);
    }

    @DeleteMapping("/delete-employee-by-id/{id}")
    @ApiOperation(value = "deleteEmployeeById", notes = "Endpoint for deleting a Employee by id", response = EmployeeDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Employee id, String", required = true, dataType = "String")})
    public void deleteEmployeeById(@PathVariable String id) {
        demoEmpService.deleteEmployeeById(id);
    }
}
