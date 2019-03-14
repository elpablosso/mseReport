package com.pablo.application.entity.project;
import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {

    @Id
    private String number;

    private String name;

    private int budget;

    public Project() {
    }

    public Project(String projectNumber) {
        this.number = projectNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

}
