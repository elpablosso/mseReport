package com.maven.pablo.reportingtool.service.implementation.ProjectEmployee;
import com.maven.pablo.reportingtool.entity.Employee;
import com.maven.pablo.reportingtool.service.interfaces.IEmployeeService;
import com.maven.pablo.reportingtool.service.interfaces.IEmployeesInProjectService;
import com.maven.pablo.reportingtool.service.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesInProjectService implements IEmployeesInProjectService {

    IProjectService projectService;
    IEmployeeService employeeService;

    @Autowired
    public EmployeesInProjectService(IProjectService projectService, IEmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> employeesInProjectByNumber(String projectNumber) {
        return projectService.findProjectByProjectNumber(projectNumber).getEmployees();
    }

    @Override
    public List<String> employeesInProjectByNumberAsString(String projectNumber) {
        return projectService.findProjectByProjectNumber(projectNumber).getEmployees().stream()
                .map(Employee::getId).collect(Collectors.toList());
    }

    @Override
    public void addEmployeeToProjectById(String projectNumber, String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        projectService.addEmployeeToProject(projectNumber,employee);
    }

    @Override
    public void removeEmployeeFromProjectById(String projectNumber, String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        projectService.removeEmployeeFromProject(projectNumber, employee);
    }


}
