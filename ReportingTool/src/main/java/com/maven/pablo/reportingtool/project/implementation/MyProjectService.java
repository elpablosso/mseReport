package com.maven.pablo.reportingtool.project.implementation;
import com.maven.pablo.reportingtool.project.dto.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MyProjectService implements com.maven.pablo.reportingtool.project.ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public MyProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Collection<Project> getAllProjects() {
        return projectRepository.findAll();
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
    public List<Project> findProjectByForm(ProjectForm form) {
        return getAllProjects().stream()
                .filter(c-> c.getNumber().contains(form.getNumber()))
                .filter(c->c.getTitle().contains(form.getTitle()))
                .collect(Collectors.toList());
    }
}

