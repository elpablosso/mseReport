package com.maven.pablo.reportingtool.Service.Implementation.ProjectEmployee;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Service.Interface.IEmployeeService;
import com.maven.pablo.reportingtool.Service.Interface.IEmployeesInProjectService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeesInProjectService implements IEmployeesInProjectService {

    @Autowired
    IProjectService projectService;
    @Autowired
    IEmployeeService employeeService;


    @Override
    public Set<Employee> employeesInProjectByNumber(String projectNumber) {
        return projectService.findProjectByProjectNumber(projectNumber).getEmployees();
    }

    @Override
    public Set<String> employeesInProjectByNumberAsString(String projectNumber) {
        return projectService.findProjectByProjectNumber(projectNumber).getEmployees().stream()
                .map(Employee::getId).collect(Collectors.toSet());
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
