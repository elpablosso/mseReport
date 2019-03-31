package com.maven.pablo.reportingtool.Service.Implementation;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Repository.ProjectRepository;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import com.maven.pablo.reportingtool.Service.Response.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Project> getListOfAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getListOfOpenProjects() {
        return projectRepository.findOpenedProjects();
    }

    @Override
    public List<Project> getListOfClosedProjects() {
        return projectRepository.findClosedProjects();
    }

    @Override
    public List<Project> listOfProjectsWithBudgetHigher(int bot) {
        return projectRepository.findProjectsWithBudgetHigherThan(bot);
    }

    @Override
    public List<Project> listOfProjectsWithBudgetLower(int top) {
        return projectRepository.findProjectsWithBudgetLowerThan(top);
    }

    @Override
    public List<Project> listOfProjectsWithBudgetBetween(int bot, int top) {
        return projectRepository.findProjectsWithBudgetBetween(bot,top);
    }

    @Override
    public List<Project> listOfProjectsWithNameContaining(String name) {
        return projectRepository.listOfProjectsWithNameContaining(name);
    }

    @Override
    public Project findProjectByProjectNumber(String number) {
        return projectRepository.findProjectByNumber(number);
    }

    @Override
    public void saveProjectInRepository(Project project) {
        projectRepository.save(project);
    }

    @Override
    public ProjectInfo convertSingleProjectIntoResponse(Project project) {
        return new ProjectInfo(project);
    }

    @Override
    public List<ProjectInfo> convertListOfProjectsIntoResponse(Collection<Project> projectList) {
        return projectList.stream().map(ProjectInfo::new).collect(Collectors.toList());
    }

    @Override
    public void removeProjectByNumber(String projectNumber) {
        projectRepository.deleteProjectByNumber(projectNumber);
    }

    @Override
    public Project createProjectFromResponse(ProjectInfo projectInfo) {
        Project project = new Project();

        if(projectInfo.getProjectNumber()!=null)
        project.setNumber(projectInfo.getProjectNumber());

        if(projectInfo.getProjectTitle()!=null)
        project.setTitle(projectInfo.getProjectTitle());

        if(projectInfo.getProjectBudget()!=0)
        project.setBudget(projectInfo.getProjectBudget());

        if(projectInfo.getUsers()!=null)
        project.setEmployees(employeeService.getEmployeeSetFromIdList(projectInfo.getUsers()));

        return project;
    }
}

