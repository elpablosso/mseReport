package com.pablo.application.entity.project;
import com.pablo.application.repository.ProjectRepository;
import com.pablo.application.entity.department.ProjectDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@ComponentScan("com/pablo/application/entity/project/department")
@Service
public class ProjectService {

    @Autowired
    private ProjectDepartmentService projectDepartmentService;
    @Autowired
    private ProjectRepository projectRepository;

    public void addUser(String userId, String projectNumber){

    }


    public boolean hasNoSuchProjectNumber(String projectNumber){
        return Objects.isNull(projectRepository.findByProjectNumber(projectNumber));
    }

    public String createAndSaveByProjectNumber(String projectNumber){
        Project project = new Project(projectNumber);
        projectRepository.save(project);
        return "Project saved";
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
        return projectRepository.findByProjectNumber(projectNumber);
    }

}