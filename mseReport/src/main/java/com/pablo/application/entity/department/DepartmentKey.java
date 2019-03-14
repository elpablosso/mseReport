package com.pablo.application.entity.department;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DepartmentKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "project_number")
    private String projectNumber;

    public DepartmentKey() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentKey)) return false;
        DepartmentKey that = (DepartmentKey) o;
        return Objects.equals(getProjectNumber(), that.getProjectNumber()) &&
                Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectNumber(), getUserId());
    }
}