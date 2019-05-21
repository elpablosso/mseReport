package com.maven.pablo.reportingtool.employee.entity;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import com.maven.pablo.reportingtool.report.entity.Report;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


    @Entity
    @Table(name = "employee")
    public class Employee {

        @Id
        private String id;
        private String email;
        private String name;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "leader")
        Set<Project> projects;

        @OneToMany(mappedBy = "employee")
        Set<ProjectDetails> details;

        @ManyToMany
        @JoinTable(name="unread_reports",
        joinColumns = @JoinColumn(name="employee_id"),
        inverseJoinColumns = @JoinColumn(name = "report_id"))
        List<Report> unreadReports = new ArrayList<>();

        private String username;
        private String password;
        private String role;

        private int salary;
        private int bonus;

        public Set<ProjectDetails> getDetails() {
            return details;
        }

        public void setDetails(Set<ProjectDetails> details) {
            this.details = details;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        public Set<Project> getProjects() {
            return projects;
        }

        public void setProjects(Set<Project> projects) {
            this.projects = projects;
        }

        public List<Report> getUnreadReports() {
            return unreadReports;
        }

        public void setUnreadReports(List<Report> unreadReports) {
            this.unreadReports = unreadReports;
        }
    }
