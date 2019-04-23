package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.project.entity.Project;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ProjectService {

    Collection<Project> getAllProjects();
    Collection<Project> getActiveProjects();
    Collection<Project> getClosedProjects();
    Collection<Project> getProjectsWithBudgetHigher(int bot);
    Collection<Project> getProjectsWithBudgetLower(int high);
    Collection<Project> getProjectsWithBudgetBetween(int bot, int high);
    Collection<Project> getProjectsWithNameContaining(String name);

    Project findProjectByProjectNumber(String number);
    List<Project> findProjectByForm(ProjectForm form);

    void saveProjectInRepository(Project project);
    void removeProjectByNumber(String projectNumber);

    void increaseModelling(String projectId, BigDecimal value);
    void increaseDrawings(String projectId, BigDecimal value);
    void increaseDocumentation(String projectId, BigDecimal value);
    void increaseCorrespondence(String projectId, BigDecimal value);

}
