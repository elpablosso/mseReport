package com.pablo.application.entity.department;
import javax.persistence.*;
import java.math.BigDecimal;


/* This class represents hours spent
    in specified project department
    in this case there are four departments :
    MODELLING
    DRAWINGS
    CORRESPONDENCE
    DOCUMENTATION         **/

@Entity
public class ProjectDepartment{

    @EmbeddedId
    DepartmentKey key;

    // THERE FIELDS REPRESENT TIME SPENT IN SPECIFIC AREAS OF PROJECT
    // THE UNIT IS AN HOUR
    // SAVED VALUES OF TIME SPENT IN PROJECTS WILL BE ROUNDED UP TO 1/4 HOUR

    private BigDecimal drawings;
    private BigDecimal correspondence;
    private BigDecimal modelling;
    private BigDecimal documentation;

    public ProjectDepartment() {
    }

    public void setDrawings(BigDecimal drawings) {
        this.drawings = drawings;
    }

    public void setCorrespondence(BigDecimal correspondence) {
        this.correspondence = correspondence;
    }

    public void setModelling(BigDecimal modelling) {
        this.modelling = modelling;
    }

    public void setDocumentation(BigDecimal documentation) {
        this.documentation = documentation;
    }

    public BigDecimal getDrawings() {
        return drawings;
    }

    public BigDecimal getCorrespondence() {
        return correspondence;
    }

    public BigDecimal getModelling() {
        return modelling;
    }

    public BigDecimal getDocumentation() {
        return documentation;
    }

    public DepartmentKey getKey() {
        return key;
    }

    public void setKey(DepartmentKey key) {
        this.key = key;
    }
}
