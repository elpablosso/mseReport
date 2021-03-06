package com.maven.pablo.reportingtool.project.entity;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Employee employee;

    private BigDecimal modelling;
    private BigDecimal correspondence;
    private BigDecimal documentation;
    private BigDecimal drawings;
    private BigDecimal staticCalculations;
    private BigDecimal other;
    private BigDecimal additionalHours;


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getStaticCalculations() {
        return staticCalculations;
    }

    public void setStaticCalculations(BigDecimal staticCalculations) {
        this.staticCalculations = staticCalculations;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }
}
