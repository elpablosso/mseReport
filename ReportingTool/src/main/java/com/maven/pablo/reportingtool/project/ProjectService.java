package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.exceptions.ProjectNotFoundException;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> findAll();
    List<Project> findByForm(ProjectDto form);

    Project findByNumber(String number) throws ProjectNotFoundException;

    boolean projectOfNumberExist(String number);

    void save(Project project);
    void delete(Project project);
}
