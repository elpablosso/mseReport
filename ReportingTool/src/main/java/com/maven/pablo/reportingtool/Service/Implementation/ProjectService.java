package com.maven.pablo.reportingtool.Service.Implementation;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Repository.ProjectRepository;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import com.maven.pablo.reportingtool.Service.Response.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Collection<Project> getListOfAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Collection<Project> getListOfOpenProjects() {
        return projectRepository.findOpenedProjects();
    }

    @Override
    public Collection<Project> getListOfClosedProjects() {
        return projectRepository.findClosedProjects();
    }

    @Override
    public Collection<Project> getProjectsWithBudgetHigher(int bot) {
        return projectRepository.findProjectsWithBudgetHigherThan(bot);
    }

    @Override
    public Collection<Project> getProjectsWithBudgetLower(int top) {
        return projectRepository.findProjectsWithBudgetLowerThan(top);
    }

    @Override
    public Collection<Project> getProjectsWithBudgetBetween(int bot, int top) {
        return projectRepository.findProjectsWithBudgetBetween(bot,top);
    }

    @Override
    public Collection<Project> getProjectsWithNameContaining(String name) {
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
    public void removeProjectByNumber(String projectNumber) {
        projectRepository.delete(findProjectByProjectNumber(projectNumber));
    }

    @Override
    public void addEmployeeToProject(String projectNumber, Employee employee) {
        Project project = projectRepository.findProjectByNumber(projectNumber);
        Set<Employee> employees = project.getEmployees();
        employees.add(employee);
        project.setEmployees(employees);
        projectRepository.save(project);
    }

    @Override
    public void removeEmployeeFromProject(String projectNumber, Employee employee) {
        Project project = projectRepository.findProjectByNumber(projectNumber);
        Set<Employee> employees = project.getEmployees();
        employees.remove(employee);
        project.setEmployees(employees);
        projectRepository.save(project);
    }

    @Override
    public Project getProjectFromResponse(ProjectInfo info) {
        Project project = new Project();
        project.setNumber(info.getProjectNumber());
        project.setTitle(info.getProjectTitle());
        project.setBudget(info.getProjectBudget());
        return project;
    }

    @Override
    public List<ProjectInfo> allProjectsAsResponse(Collection<Project> projects) {
        return projects.stream().map(ProjectInfo::new).collect(Collectors.toList());}
}

