package com.maven.pablo.reportingtool.project.dto;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class ProjectForm {

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

    public ProjectForm() {
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
