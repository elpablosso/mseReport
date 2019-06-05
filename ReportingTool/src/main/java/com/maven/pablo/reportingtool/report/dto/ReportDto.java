package com.maven.pablo.reportingtool.report.dto;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.enums.Department;
import com.maven.pablo.reportingtool.project.entity.Project;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ReportDto {

    private Integer repoId;
    private String employeeId;
    private Employee employee;
    private Project project;


    @NotNull
    @NotEmpty(message = "Select project!")
    private String projectId;

    @NotNull
    @NotEmpty(message = "Write something!")
    private String description;

    @NotNull(message = "How long?")
    private BigDecimal time;

    @NotEmpty(message = "Select department!")
    private String department;
    private boolean additionalRange;
    private LocalDate date;

    private int id;

    public ReportDto(String employeeId, String projectId, BigDecimal time, Department department, boolean additionalRange) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.time = time;
        this.department = department.toString();
        this.additionalRange = additionalRange;
        this.date = LocalDate.now();
    }

    public ReportDto() {
    }

    public Integer getRepoId() {
        return repoId;
    }

    public void setRepoId(Integer repoId) {
        this.repoId = repoId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
