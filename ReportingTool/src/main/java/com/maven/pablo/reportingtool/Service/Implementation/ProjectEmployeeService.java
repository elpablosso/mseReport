package com.maven.pablo.reportingtool.Service.Implementation;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Service.Interface.IEmployeeService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectEmployeeService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class ProjectEmployeeService implements IProjectEmployeeService {

    @Autowired
    IProjectService projectService;
    @Autowired
    IEmployeeService employeeService;

    @Override
    public Set<Employee> getEmployeeSetFromProjectByNumber(String projectNumber) {
        return projectService.findProjectByProjectNumber(projectNumber).getEmployees();
    }

    @Override
    public Set<Project> getListOfProjectsByUserId(String userId) {
        return employeeService.getEmployeeById(userId).getProjects();
    }

    @Override
    public void addProjectToEmployee(String projectNumber, String userId) {
        Project project = projectService.findProjectByProjectNumber(projectNumber);
        Set<Project> projects = getListOfProjectsByUserId(userId);
        projects.add(project);
        updateProjectSetInEmployee(userId,projects);
    }

    @Override
    public void addUserToTheProject(String projectNumber, String userId) {
        Employee employee = employeeService.getEmployeeById(userId);
        Set<Employee> employees = getEmployeeSetFromProjectByNumber(projectNumber);
        employees.add(employee);
        updateUserSetInProject(projectNumber,employees);
    }

    @Override
    public void updateProjectSetInEmployee(String employeeId, Set<Project> set) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        employee.setProjects(set);
        employeeService.saveEmployeeInRepository(employee);
    }

    @Override
    public void updateUserSetInProject(String projectNumber, Set<Employee> set) {
        Project project = projectService.findProjectByProjectNumber(projectNumber);
        project.setEmployees(set);
        projectService.saveProjectInRepository(project);
    }
}
