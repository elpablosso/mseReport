package com.maven.pablo.reportingtool.project.entity.key;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProjectEmployeeKey implements Serializable {

    String employeeId;
    String projectNumber;

    public ProjectEmployeeKey() {
    }

    public ProjectEmployeeKey(String employeeId, String projectNumber) {
        this.employeeId = employeeId;
        this.projectNumber = projectNumber;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }
}
