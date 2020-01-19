package com.example.demoemp.repository;

import com.example.demoemp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DemoEmpRepository extends JpaRepository<Employee, String> {

    @Modifying
    @Transactional
    @Query(value = "delete from employee where empl_email = :email ", nativeQuery = true)
    public void deleteEmployee(@Param("email") String email);

    @Query(value = "select * from employee where empl_department = :dept  ", nativeQuery = true)
    public List<Employee> findAllByDept(@Param("dept") String dept);
}