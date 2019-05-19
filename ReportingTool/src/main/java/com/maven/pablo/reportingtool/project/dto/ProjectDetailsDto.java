package com.maven.pablo.reportingtool.project.dto;

import java.math.BigDecimal;

public class ProjectDetailsDto {

    private String projectNumber;
    private String employeeId;

    private BigDecimal modelling;
    private BigDecimal correspondence;
    private BigDecimal documentation;
    private BigDecimal drawings;
    private BigDecimal additionalHours;

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getModelling() {
        return modelling;
    }

    public void setModelling(BigDecimal modelling) {
        this.modelling = modelling;
    }

    public BigDecimal getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(BigDecimal correspondence) {
        this.correspondence = correspondence;
    }

    public BigDecimal getDocumentation() {
        return documentation;
    }

    public void setDocumentation(BigDecimal documentation) {
        this.documentation = documentation;
    }

    public BigDecimal getDrawings() {
        return drawings;
    }

    public void setDrawings(BigDecimal drawings) {
        this.drawings = drawings;
    }

    public BigDecimal getAdditionalHours() {
        return additionalHours;
    }

    public void setAdditionalHours(BigDecimal additionalHours) {
        this.additionalHours = additionalHours;
    }
}
