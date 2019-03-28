package com.maven.pablo.reportingtool.Service;

import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Entity.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectInfo {

    private String projectNumber;

    private LocalDate date;

    private String projectName;

    private Set<String> usersIds;

    private int projectBudget;

    private boolean closed;

    public ProjectInfo(Project project) {
        usersIds = new HashSet<>();
        setProjectNumber(project.getNumber());
        setProjectName(project.getName());
        setProjectBudget(project.getBudget());
        setDate(project.getDateStarted());
        setClosed(project.isClosed());
        usersIds.addAll(project.getUsers().stream().map(User::getUserId).collect(Collectors.toSet()));
    }

    public ProjectInfo createFromProject(Project project){
        return new ProjectInfo(project);
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<String> getUsers() {
        return usersIds;
    }

    public void setUsers(Set<String> users) {
        this.usersIds = users;
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
