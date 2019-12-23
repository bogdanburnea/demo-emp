package com.example.demoemp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @NotNull
    private String empl_id;

    @NotNull
    @Column(name = "empl_name")
    private String empl_name;

    @NotNull
    @Column(name = "empl_date_of_birth")
    private LocalDateTime empl_date_of_birth;

    @NotNull
    @Column(name = "empl_date_of_hire")
    private LocalDateTime empl_date_of_hire;

    @NotNull
    @Column(name = "empl_job")
    private String empl_job;


    @NotNull
    @Column(name = "empl_department")
    private String empl_department;

    @NotNull
    @Column(name = "last_updated_by")
    private String last_updated_by;

    @NotNull
    @Column(name = "last_updated_at")
    private LocalDateTime last_updated_at;
}