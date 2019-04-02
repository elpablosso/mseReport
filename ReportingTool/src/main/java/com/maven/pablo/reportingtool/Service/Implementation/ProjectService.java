package com.maven.pablo.reportingtool.Service.Implementation;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Repository.ProjectRepository;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;


@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Collection<Project> getCollectionOfAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Collection<Project> getCollectionOfOpenProjects() {
        return projectRepository.findOpenedProjects();
    }

    @Override
    public Collection<Project> getCollectionOfClosedProjects() {
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
        return projectRepository.findProjectsWithBudgetBetween(bot, top);
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
        List<Employee> employees = project.getEmployees();
        employees.add(employee);
        project.setEmployees(employees);
        projectRepository.save(project);
    }

    @Override
    public void removeEmployeeFromProject(String projectNumber, Employee employee) {
        Project project = projectRepository.findProjectByNumber(projectNumber);
        List<Employee> employees = project.getEmployees();
        employees.remove(employee);
        project.setEmployees(employees);
        projectRepository.save(project);
    }

}

