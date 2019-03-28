package com.pablo.application.service;
import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.user.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProjectInfo {

    private String projectNumber;

    private LocalDate date;

    private String projectName;

    private Set<String> users;

    private int projectBudget;

    private boolean closed;

    public ProjectInfo(Project project) {
        users = new HashSet<>();
        setProjectNumber(project.getNumber());
        setProjectName(project.getName());
        setProjectBudget(project.getBudget());
        setDate(project.getDate());
        setClosed(project.isClosed());
        users.addAll(project.getUsers().stream().map(User::getUserId).collect(Collectors.toSet()));
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
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
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
