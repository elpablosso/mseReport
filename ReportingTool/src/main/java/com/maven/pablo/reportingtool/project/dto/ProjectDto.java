package com.maven.pablo.reportingtool.project.dto;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import javax.validation.constraints.*;

public class ProjectDto {

    @NotNull(message = "Project number can not be empty!")
    @Size(min=3, max=20, message = "Number must be between 3 and 20")
    private String number;

    @NotNull(message = "Title can not be empty!")
    @Size(min=5, max=50, message = "Title must be between 5 and 50")
    private String title;

    @NotNull(message = "Budget can not be empty!")
    @DecimalMin(value = "0", message = "Budget must be number higher than 0!")
    @DecimalMax(value = "1000000", message = "Budget must be lower than 1000000!")
    private Integer budget;

    @NotEmpty(message = "Select leader!")
    private String leaderId;

    private boolean closed;
    private Employee leader;

    public ProjectDto() {
        this.number="";
        this.title="";
        this.leaderId="";
        this.closed=false;

    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }
}
