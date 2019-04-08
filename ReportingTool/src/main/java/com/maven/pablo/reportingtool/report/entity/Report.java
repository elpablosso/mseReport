package com.maven.pablo.reportingtool.report.entity;
import com.maven.pablo.reportingtool.employee.enums.Departments;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Report {

    @Id
    private String employeeId;
    private String projectId;
    private BigDecimal time;
    private Departments departments;
    private LocalDate date;
    private boolean additionalRange;

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
