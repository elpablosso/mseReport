package com.maven.pablo.reportingtool.project;

public class ProjectDto {

    private String number;
    private String title;
    private int modelling;
    private int correspondence;
    private int documentation;
    private int drawings;
    private int additionalHours;
    private int budget;
    private boolean closed;

    public ProjectDto(Builder builder){
        number = builder.number;
        title = builder.title;
        modelling = builder.modelling;
        correspondence = builder.correspondence;
        documentation = builder.documentation;
        drawings = builder.drawings;
        additionalHours = builder.additionalHours;
        budget = builder.budget;
        closed = builder.closed;
    }

    public static class Builder {

        private final String number;

        private String title = "";
        private int modelling = 0;
        private int correspondence = 0;
        private int documentation = 0;
        private int drawings = 0;
        private int additionalHours = 0;
        private int budget = 0;
        private boolean closed = false;


        public Builder(String number) {
            this.number = number;
        }

        public Builder title(String val) {
            title = val;
            return this;
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

        public Builder budget(int val) {
            budget = val;
            return this;
        }

        public Builder closed(boolean val) {
            closed = val;
            return this;
        }

        public ProjectDto build() {
            return new ProjectDto(this);
        }
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

    public boolean isClosed() {
        return closed;
    }
}
