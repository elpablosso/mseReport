package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.project.dto.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;
import java.util.Collection;
import java.util.List;

public interface ProjectService {

    Collection<Project> getAllProjects();

    Project findProjectByProjectNumber(String number);
    List<Project> findProjectByForm(ProjectForm form);

    void saveProjectInRepository(Project project);
    void removeProjectByNumber(String projectNumber);

}
