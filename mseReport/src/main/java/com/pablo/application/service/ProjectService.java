package com.pablo.application.service;
import com.pablo.application.entity.project.Project;
import com.pablo.application.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@ComponentScan("com/pablo/application/entity/project/department")
@Service
public class ProjectService {

    @Autowired
    ProjectDepartmentService projectDepartmentService;
    @Autowired
    ProjectRepository projectRepository;

    public String createNewProject(String projectNumber){
        if(hasNoSuchProjectNumber(projectNumber)){
            Project project = new Project(projectNumber);
            projectRepository.save(project);
            projectDepartmentService.createNewProjectDepartment(projectNumber);
            return "Project saved";
        } else return "This project number is already in database!";
    }

    public boolean hasNoSuchProjectNumber(String projectNumber){
        return Objects.isNull(projectRepository.findByNumber(projectNumber));
    }

    public Project saveProject(Project project){
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