package com.maven.pablo.reportingtool.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {


    @Column(name = "employee_id")
    @Id
    private String id;

    private String email;
    private String name;

    // FINANCES //
    private int salary;
    private int bonus;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
