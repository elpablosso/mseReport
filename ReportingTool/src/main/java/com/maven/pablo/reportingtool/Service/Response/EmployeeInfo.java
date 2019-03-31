package com.maven.pablo.reportingtool.Service.Response;

import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeInfo {

    private String id;

    private String email;
    private String name;

    // FINANCES //
    private int salary;
    private int bonus;

    private Set<String> projectIds;
    private Set<Project> projects;

    private EmployeeInfo() {
        setId("");
        setName("");
        setEmail("");
        setSalary(0);
        setBonus(0);
        projectIds = new HashSet<>();
        projects = new HashSet<>();
    }

    public EmployeeInfo(Employee employee) {
        EmployeeInfo employeeInfo = new EmployeeInfo();
        if(employee.getId()!=null)
            employeeInfo.setId(employee.getId());
        if(employee.getName()!=null)
            employeeInfo.setName(employee.getName());
        if(employee.getProjects()!=null) {
            projectIds = employee.getProjects().stream().map(Project::getNumber).collect(Collectors.toSet());
            projects = employee.getProjects();
        }
    }

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

    public Set<String> getProjectIds() {
        return projectIds;
    }
}
