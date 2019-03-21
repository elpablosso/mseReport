package com.pablo.application.service;
import com.pablo.application.entity.project.Project;
import com.pablo.application.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@ComponentScan("com/pablo/application/entity/project/department")
@Service
public class ProjectService {

    @Autowired
    private ProjectDepartmentService projectDepartmentService;
    @Autowired
    private ProjectRepository projectRepository;


    public boolean hasNoSuchProjectNumber(String projectNumber){
        return Objects.isNull(projectRepository.findByNumber(projectNumber));
    }

    public Project saveProject(Project project){
        project.setDate(LocalDate.now());
        return projectRepository.save(project);
    }

    public List<Project> findAll(){
        return (List<Project>)projectRepository.findAll();
    }

    public List<Project> sortedByBudget() {
        List<Project> listToSort = findAll();
        listToSort.sort(Comparator.comparingInt(Project::getBudget));
        return listToSort;
    }

    public Project findByNumber(String projectNumber){
        return projectRepository.findByNumber(projectNumber);
    }

}