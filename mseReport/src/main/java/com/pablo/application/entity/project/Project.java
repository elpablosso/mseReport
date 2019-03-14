package com.pablo.application.entity.project;
import javax.persistence.*;

@Entity
public class Project {

    @Id
    private String projectNumber;

    private String projectName;

    private int projectBudget;

    public Project() {
    }

    public Project(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(int projectBudget) {
        this.projectBudget = projectBudget;
    }

}
