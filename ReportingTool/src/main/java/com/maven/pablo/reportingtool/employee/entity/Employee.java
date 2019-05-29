package com.maven.pablo.reportingtool.employee.entity;
import com.maven.pablo.reportingtool.employee.enums.Role;
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
        private Set<Project> projectsRoleLeader;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "designer")
        private Set<Project> projectsRoleDesigner;

        @OneToMany(mappedBy = "employee")
        private Set<ProjectDetails> details;

        private String username;
        private String password;
        private Role role;


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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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

        public Set<Project> getProjectsRoleLeader() {
            return projectsRoleLeader;
        }

        public void setProjectsRoleLeader(Set<Project> projectsRoleLeader) {
            this.projectsRoleLeader = projectsRoleLeader;
        }

        public Set<Project> getProjectsRoleDesignerr() {
            return projectsRoleDesigner;
        }

        public void setProjectsRoleDesignerr(Set<Project> projectsRoleDesignerr) {
            this.projectsRoleDesigner = projectsRoleDesignerr;
        }
    }
