package com.maven.pablo.reportingtool.Service.Interface;
import com.maven.pablo.reportingtool.Entity.Project;

import java.util.List;
import java.util.Set;

public interface IProjectsOfEmployeeService {

    List<Project> getProjectsOfEmployeeById(String employeeId);
    List<String> getProjectsOfEmployeeByIdAsString(String employeeId);

    void addProjectToEmployee(String projectNumber, String employeeId);
    void removeProjectFromEmployee(String projectNumber, String employeeId);

}
