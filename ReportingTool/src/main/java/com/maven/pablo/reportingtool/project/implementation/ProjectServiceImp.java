package com.maven.pablo.reportingtool.project.implementation;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;


@Service
public class ProjectServiceImp implements com.maven.pablo.reportingtool.project.ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Collection<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Collection<Project> getActiveProjects() {
        return projectRepository.findByClosedTrue();
    }

    @Override
    public Collection<Project> getClosedProjects() {
        return projectRepository.findByClosedFalse();
    }

    @Override
    public Collection<Project> getProjectsWithBudgetHigher(int bot) {
        return projectRepository.findByBudgetGreaterThan(bot);
    }

    @Override
    public Collection<Project> getProjectsWithBudgetLower(int top) {
        return projectRepository.findByBudgetLessThan(top);
    }

    @Override
    public Collection<Project> getProjectsWithBudgetBetween(int bot, int top) {
        return projectRepository.findByBudgetBetween(bot, top);
    }

    @Override
    public Collection<Project> getProjectsWithNameContaining(String name) {
        return projectRepository.findByTitleContaining(name);
    }

    @Override
    public Project findProjectByProjectNumber(String number) {
        return projectRepository.findByNumber(number);
    }

    @Override
    public void saveProjectInRepository(Project project) {
        projectRepository.save(project);
    }


    @Override
    public void removeProjectByNumber(String projectNumber) {
        projectRepository.delete(findProjectByProjectNumber(projectNumber));
    }

    @Override
    public void increaseModelling(String projectId, BigDecimal value) {
       Project project = findProjectByProjectNumber(projectId);
       project.setModelling(project.getModelling().add(value));
    }

    @Override
    public void increaseDrawings(String projectId, BigDecimal value) {
        Project project = findProjectByProjectNumber(projectId);
        project.setDrawings(project.getDrawings().add(value));
    }

    @Override
    public void increaseDocumentation(String projectId, BigDecimal value) {
        Project project = findProjectByProjectNumber(projectId);
        project.setDocumentation(project.getDocumentation().add(value));
    }

    @Override
    public void increaseCorrespondence(String projectId, BigDecimal value) {
        Project project = findProjectByProjectNumber(projectId);
        project.setCorrespondence(project.getCorrespondence().add(value));
    }
}

