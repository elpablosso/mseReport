package com.maven.pablo.reportingtool.project.implementation;
import com.maven.pablo.reportingtool.project.ProjectDetailsService;
import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import com.maven.pablo.reportingtool.project.entity.repository.ProjectDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class MyProjectDetailsService implements ProjectDetailsService {

    private ProjectDetailsRepository projectDetailsRepository;

    @Autowired
    public MyProjectDetailsService(ProjectDetailsRepository projectDetailsRepository) {
        this.projectDetailsRepository = projectDetailsRepository;
    }

    @Override
    public void increaseModelling(String projectId, String employeeId, BigDecimal value) {

    }

    @Override
    public void increaseDrawings(String projectId, String employeeId, BigDecimal value) {
        System.out.println("Increased");
    }

    @Override
    public void increaseDocumentation(String projectId, String employeeId, BigDecimal value) {

    }

    @Override
    public void increaseCorrespondence(String projectId, String employeeId, BigDecimal value) {

    }

    @Override
    public ProjectDetails createNewProjectDetails(String projectId, String employeeId) {
        return null;
    }
}
