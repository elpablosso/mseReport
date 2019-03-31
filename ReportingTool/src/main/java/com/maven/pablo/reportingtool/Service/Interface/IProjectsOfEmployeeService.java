package com.maven.pablo.reportingtool.Service.Interface;
import com.maven.pablo.reportingtool.Entity.Project;
import java.util.Set;

public interface IProjectsOfEmployeeService {

    Set<Project> getProjectsOfEmployeeById(String employeeId);
    Set<String> getProjectsOfEmployeeByIdAsString(String employeeId);

    void addProjectToEmployee(String projectNumber, String employeeId);
    void removeProjectFromEmployee(String projectNumber, String employeeId);

}
