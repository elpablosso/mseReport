package com.maven.pablo.reportingtool.project;
import java.time.LocalDate;

public class ProjectDto {

    private String number;
    private LocalDate date;
    private String title;
    private int modelling;
    private int correspondence;
    private int documentation;
    private int drawings;
    private int additionalHours;
    private int budget;
    private boolean closed;

    public ProjectDto() {
    }

    public ProjectDto(String number, LocalDate date, String title, int modelling,
                      int correspondence, int documentation, int drawings, int budget, int additionalHours, boolean closed) {
        this.number = number;
        this.date = date;
        this.title = title;
        this.modelling = modelling;
        this.correspondence = correspondence;
        this.documentation = documentation;
        this.drawings = drawings;
        this.budget = budget;
        this.additionalHours=additionalHours;
        this.closed = closed;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getModelling() {
        return modelling;
    }

    public void setModelling(int modelling) {
        this.modelling = modelling;
    }

    public int getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(int correspondence) {
        this.correspondence = correspondence;
    }

    public int getDocumentation() {
        return documentation;
    }

    public void setDocumentation(int documentation) {
        this.documentation = documentation;
    }

    public int getDrawings() {
        return drawings;
    }

    public void setDrawings(int drawings) {
        this.drawings = drawings;
    }

    public int getAdditionalHours() {
        return additionalHours;
    }

    public void setAdditionalHours(int additionalHours) {
        this.additionalHours = additionalHours;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
