package com.maven.pablo.reportingtool.project.implementation;
import com.maven.pablo.reportingtool.exceptions.ProjectNotFoundException;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MyProjectService implements com.maven.pablo.reportingtool.project.ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public MyProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findByNumber(String number) throws ProjectNotFoundException {
        return projectRepository.findByNumber(number).orElseThrow(ProjectNotFoundException::new);
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public boolean projectOfNumberExist(String number) {
        return projectRepository.findByNumber(number).isPresent();
    }

    @Override
    public void deleteProjectByNumber(String projectNumber) throws ProjectNotFoundException {
        deleteProject(findByNumber(projectNumber));
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public List<Project> findByForm(ProjectDto form) {
        return findAll().stream()
                .filter(c-> c.getNumber().contains(form.getNumber()))
                .filter(c->c.getTitle().contains(form.getTitle()))
                .collect(Collectors.toList());
    }
}

