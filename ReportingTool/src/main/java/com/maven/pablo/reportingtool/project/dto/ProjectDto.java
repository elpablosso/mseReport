package com.maven.pablo.reportingtool.project.dto;

public class ProjectDto {

    private String number;
    private String title;
    private int budget;
    private boolean closed;
    private String leaderId;

    public ProjectDto(String number, String title, int budget, boolean closed, String leaderId) {
        this.number = number;
        this.title = title;
        this.budget = budget;
        this.closed = closed;
        this.leaderId = leaderId;
    }

    public String getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public int getBudget() {
        return budget;
    }

    public boolean isClosed() {
        return closed;
    }

    public String getLeaderId() {
        return leaderId;
    }
}
