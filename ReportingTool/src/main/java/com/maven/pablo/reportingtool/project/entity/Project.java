package com.maven.pablo.reportingtool.project.entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Project {

    @Id
    private String number;
    private LocalDate dateStarted;
    private String title;

    /// TOTAL TIME SPENT IN THE PROJECT IN SPECIFIED DEPARTMENTS
    private BigDecimal modelling;
    private BigDecimal correspondence;
    private BigDecimal documentation;
    private BigDecimal drawings;
    private BigDecimal budget;
    private BigDecimal additionalHours;

    private boolean closed;

    public Project() {
    }

    public BigDecimal getAdditionalHours() {
        return additionalHours;
    }

    public void setAdditionalHours(BigDecimal additionalHours) {
        this.additionalHours = additionalHours;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}