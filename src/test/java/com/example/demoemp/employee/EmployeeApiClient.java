package com.example.demoemp.employee;

import com.example.demoemp.employee.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeApiClient {
    private TestRestTemplate restTemplate;

    @Autowired
    public EmployeeApiClient(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public final ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return restTemplate.exchange("/api/get-all-employees", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<EmployeeDTO>>() {
                });
    }

    public final ResponseEntity<List<EmployeeDTO>> getEmployeeById(String email) {
        return restTemplate.exchange("/api/get-employee-by-id/{id}", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<EmployeeDTO>>() {
                }, email);
    }

    public final ResponseEntity<List<EmployeeDTO>> getEmployeeByDept(String dept) {
        return restTemplate.exchange("/api/get-employee-by-dept/{dept}", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<EmployeeDTO>>() {
                }, dept);
    }

    public final ResponseEntity<EmployeeDTO> createEmployee(String id, EmployeeDTO employeeDTO) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<EmployeeDTO> postEntity = new HttpEntity<>(employeeDTO, headers);
        return restTemplate.exchange("/api/create-employee/{id}", HttpMethod.POST, postEntity,
                EmployeeDTO.class, id);
    }

    public final ResponseEntity<EmployeeDTO> updateEmployee(String id, EmployeeDTO employeeDTO) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<EmployeeDTO> putEntity = new HttpEntity<>(employeeDTO, headers);
        return restTemplate.exchange("/api//update-employee/{id}", HttpMethod.PUT, putEntity,
                EmployeeDTO.class, id);
    }

    public final ResponseEntity<Integer> deleteEmployeeById(String id) {
        return restTemplate.exchange("/api//delete-employee-by-email/{id}", HttpMethod.DELETE, null,
                Integer.class, id);
    }
}