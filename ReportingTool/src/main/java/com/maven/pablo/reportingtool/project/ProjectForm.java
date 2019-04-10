package com.maven.pablo.reportingtool.project;

public class ProjectForm {


    private String number;

    private String title;

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
