package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.project.dto.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;

import java.util.Collection;
import java.util.List;

public interface ProjectService {

    Collection<Project> findAll();

    Project findByNumber(String number);
    List<Project> findByForm(ProjectForm form);

    void saveProject(Project project);
    void deleteProject(Project project);
    void deleteProjectByNumber(String projectNumber);

}
