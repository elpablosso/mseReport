package com.maven.pablo.reportingtool.project;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectForm {

    @NotNull
    @Size(min=3, max=20)
    private String number;

    @NotNull
    @Size(min=5, max=50)
    private String title;

    @NotNull
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
