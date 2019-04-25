package com.maven.pablo.reportingtool.project;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectForm {

    @NotNull(message = "Project number can not be empty!")
    @Size(min=3, max=20, message = "Number must be between 3 and 20")
    private String number;

    @NotNull(message = "Title can not be empty!")
    @Size(min=5, max=50, message = "Title must be between 5 and 50")
    private String title;

    @NotNull(message = "Budget can not be empty!")
    private Integer budget;

    public ProjectForm() {
        setNumber("");
        setTitle("");
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
}
