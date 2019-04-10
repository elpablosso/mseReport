package com.maven.pablo.reportingtool.project.mapper;

import com.maven.pablo.reportingtool.project.ProjectDto;
import com.maven.pablo.reportingtool.project.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;

import java.util.Collection;
import java.util.List;

public interface ProjectMapper {

    Project newProjectFromDto(ProjectDto projectDto);
    Project newProjectFromForm(ProjectForm form);
    Project openNewProject();

    ProjectDto convertToDto(Project project);
    List<ProjectDto> convertToDto(Collection<Project> projects);

}
