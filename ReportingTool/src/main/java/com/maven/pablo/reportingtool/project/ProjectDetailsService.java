package com.maven.pablo.reportingtool.project;

import com.maven.pablo.reportingtool.project.entity.ProjectDetails;

import java.math.BigDecimal;

public interface ProjectDetailsService {

    void increaseModelling(String projectId, String employeeId, BigDecimal value);
    void increaseDrawings(String projectId, String employeeId,  BigDecimal value);
    void increaseDocumentation(String projectId, String employeeId, BigDecimal value);
    void increaseCorrespondence(String projectId, String employeeId,  BigDecimal value);

    ProjectDetails createNewProjectDetails(String projectId, String employeeId);
}
