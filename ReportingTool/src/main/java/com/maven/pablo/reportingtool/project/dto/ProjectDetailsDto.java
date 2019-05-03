package com.maven.pablo.reportingtool.project.dto;

public class ProjectDetailsDto {

    private String projectNumber;
    private String employeeId;

    private int modelling;
    private int correspondence;
    private int documentation;
    private int drawings;
    private int additionalHours;


    public ProjectDetailsDto(Builder builder){
        projectNumber = builder.projectNumber;
        employeeId = builder.employeeId;
        modelling = builder.modelling;
        correspondence = builder.correspondence;
        documentation = builder.documentation;
        drawings = builder.drawings;
        additionalHours = builder.additionalHours;
    }

    public static class Builder {

        private final String projectNumber;
        private final String employeeId;

        private int modelling = 0;
        private int correspondence = 0;
        private int documentation = 0;
        private int drawings = 0;
        private int additionalHours = 0;

        public Builder(String projectNumber, String employeeId) {
            this.projectNumber = projectNumber;
            this.employeeId = employeeId;
        }


        public Builder modelling(int val) {
            modelling = val;
            return this;
        }

        public Builder correspondence(int val) {
            correspondence = val;
            return this;
        }

        public Builder documentation(int val) {
            documentation = val;
            return this;
        }

        public Builder drawings(int val) {
            drawings = val;
            return this;
        }

        public Builder additionalHours(int val) {
            additionalHours = val;
            return this;
        }

        public ProjectDetailsDto build() {
            return new ProjectDetailsDto(this);
        }
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getModelling() {
        return modelling;
    }

    public int getCorrespondence() {
        return correspondence;
    }

    public int getDocumentation() {
        return documentation;
    }

    public int getDrawings() {
        return drawings;
    }

    public int getAdditionalHours() {
        return additionalHours;
    }
}
