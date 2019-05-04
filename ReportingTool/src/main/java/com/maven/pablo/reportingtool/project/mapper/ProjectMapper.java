package com.maven.pablo.reportingtool.project.mapper;

import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.dto.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;

import java.util.Collection;
import java.util.List;

public interface ProjectMapper {

    Project newProjectFromForm(ProjectForm form);

    ProjectDto convertToDto(Project project);
    List<ProjectDto> convertToDto(Collection<Project> projects);

}
