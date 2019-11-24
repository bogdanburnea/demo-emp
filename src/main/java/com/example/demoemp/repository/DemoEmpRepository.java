package com.example.demoemp.repository;

import com.example.demoemp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoEmpRepository extends JpaRepository<Employee, Long> {

}