package com.maven.pablo.reportingtool.entity;
import com.maven.pablo.reportingtool.service.keys.ProjectEmployeeKey;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class ProjectHours {

    @EmbeddedId
    private ProjectEmployeeKey projectEmployeeKey;

    // HOURS IN SPECIFIED DEPARTMENT
    private BigDecimal modelling;
    private BigDecimal drawings;
    private BigDecimal documentation;
    private BigDecimal correspondence;

    public ProjectEmployeeKey getProjectEmployeeKey() {
        return projectEmployeeKey;
    }

    public void setProjectEmployeeKey(ProjectEmployeeKey projectEmployeeKey) {
        this.projectEmployeeKey = projectEmployeeKey;
    }

    public BigDecimal getModelling() {
        return modelling;
    }

    public void setModelling(BigDecimal modelling) {
        this.modelling = modelling;
    }

    public BigDecimal getDrawings() {
        return drawings;
    }

    public void setDrawings(BigDecimal drawings) {
        this.drawings = drawings;
    }

    public BigDecimal getDocumentation() {
        return documentation;
    }

    public void setDocumentation(BigDecimal documentation) {
        this.documentation = documentation;
    }

    public BigDecimal getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(BigDecimal correspondence) {
        this.correspondence = correspondence;
    }
}
