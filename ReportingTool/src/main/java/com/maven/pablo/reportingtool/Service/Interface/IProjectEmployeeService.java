package com.maven.pablo.reportingtool.Service.Interface;

import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import java.util.Set;

public interface IProjectEmployeeService {

    // GETTING LIST OF USERS ACTIVE IN SOME PROJECT
    Set<Employee> getEmployeeSetFromProjectByNumber(String projectNumber);

    // GETTING SPECIFIED USERS PROJECT LIST
    Set<Project> getListOfProjectsByUserId(String userId);


    void addProjectToEmployee(String projectNumber, String userId);
    void addUserToTheProject(String projectNumber, String userId);

    default void connectUserToProject(String projectNumber, String userId){
        addUserToTheProject(projectNumber,userId);
        addProjectToEmployee(projectNumber,userId);
    }

    void updateUserSetInProject(String projectNumber, Set<Employee> set);
    void updateProjectSetInEmployee(String employeeId, Set<Project> set);
}
