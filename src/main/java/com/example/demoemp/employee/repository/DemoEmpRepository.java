package com.example.demoemp.employee.repository;

import com.example.demoemp.employee.entity.Employee;
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
    @Query(value = "delete from employee where empl_id = :id ", nativeQuery = true)
    public void deleteEmployee(@Param("id") String id);

    @Query(value = "select * from employee where empl_department = :dept  ", nativeQuery = true)
    public List<Employee> findAllByDept(@Param("dept") String dept);
}