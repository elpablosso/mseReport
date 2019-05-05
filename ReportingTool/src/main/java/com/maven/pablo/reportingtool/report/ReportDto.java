package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.enums.Department;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReportDto {

    private String employeeId;

    @NotNull
    @NotEmpty(message = "Please select any project !")
    private String projectId;

    @NotNull
    @NotEmpty(message = "What did you do ?")
    private String description;

    @NotNull(message = "How long?")
    @Min(value = 15, message = "Minimum time is 15 minutes!")
    private Integer time;

    @NotEmpty(message = "Please select department!")
    private String department;
    private boolean additionalRange;
    private LocalDate date;

    public ReportDto(String employeeId, String projectId, BigDecimal time, Department department, boolean additionalRange) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.time = time.intValue();
        this.department = department.toString();
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
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
