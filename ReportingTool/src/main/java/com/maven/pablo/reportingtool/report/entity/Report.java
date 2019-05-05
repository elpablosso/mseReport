package com.maven.pablo.reportingtool.report.entity;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.enums.Department;
import com.maven.pablo.reportingtool.project.entity.Project;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    Project project;

    @ManyToOne
    Employee employee;

    private String description;
    private BigDecimal time;
    private Department department;
    private LocalDate date;
    private boolean additionalRange;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isAdditionalRange() {
        return additionalRange;
    }

    public void setAdditionalRange(boolean additionalRange) {
        this.additionalRange = additionalRange;
    }
}
