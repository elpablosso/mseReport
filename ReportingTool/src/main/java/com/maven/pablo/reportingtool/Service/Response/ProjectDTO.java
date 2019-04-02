package com.maven.pablo.reportingtool.Service.Response;
import java.time.LocalDate;
import java.util.List;


public class ProjectDto {

    private String number;
    private LocalDate date;
    private String title;

    private List<String> employeesIds;

    private int budget;

    private boolean closed;

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

    public List<String> getEmployeesIds() {
        return employeesIds;
    }

    public void setEmployeesIds(List<String> employeesIds) {
        this.employeesIds = employeesIds;
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
