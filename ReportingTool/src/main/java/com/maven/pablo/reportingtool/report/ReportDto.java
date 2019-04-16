package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.enums.Departments;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReportDto {

    private String employeeId;
    private String projectId;
    private String description;
    private BigDecimal time;
    private Departments departments;
    private boolean additionalRange;
    private LocalDate date;

    public ReportDto(String employeeId, String projectId, BigDecimal time, Departments departments, boolean additionalRange) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.time = time;
        this.departments = departments;
        this.additionalRange = additionalRange;
        this.date = LocalDate.now();
    }

    public ReportDto() {
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
