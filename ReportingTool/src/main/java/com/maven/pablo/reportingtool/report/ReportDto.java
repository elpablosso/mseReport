package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.Departments;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReportDto {

    private String employeeId;
    private String projectId;
    private BigDecimal time;
    private Departments departments;
    private boolean additionalRange;
    private LocalDate date;

    public ReportDto() {
        date = LocalDate.now();
        setEmployeeId("");
        setProjectId("");
        setTime(BigDecimal.ZERO);
        setDepartments(null);
        setAdditionalRange(false);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
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
