package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.enums.Departments;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReportDto {

    private String employeeId;
    private String projectId;

    private String description;
    private BigDecimal time;
    private String department;
    private boolean additionalRange;
    private LocalDate date;

    public ReportDto(String employeeId, String projectId, BigDecimal time, Departments departments, boolean additionalRange) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.time = time;
        this.department = departments.toString();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
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
