package com.maven.pablo.reportingtool.Service.Response;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectInfo {

    private String projectNumber;

    private LocalDate date;

    private String projectTitle;

    private Set<String> employeesIds;

    private int projectBudget;

    private boolean closed;

    public ProjectInfo() {
    }

    public ProjectInfo(Project project) {

        employeesIds = new HashSet<>();

        if (project.getNumber() != null)
            setProjectNumber(project.getNumber());

        if (project.getTitle() != null)
            setProjectTitle(project.getTitle());

        if (project.getBudget() != 0)
            setProjectBudget(project.getBudget());

        setDate(project.getDateStarted());
        setClosed(project.isClosed());

        if (project.getEmployees() != null) {
            employeesIds.addAll(project.getEmployees().stream().map(Employee::getId).collect(Collectors.toSet()));
        }
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }


    public Set<String> getEmployeesIds() {
        return employeesIds;
    }

    public void setEmployeesIds(Set<String> employeesIds) {
        this.employeesIds = employeesIds;
    }

    public int getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(int projectBudget) {
        this.projectBudget = projectBudget;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
