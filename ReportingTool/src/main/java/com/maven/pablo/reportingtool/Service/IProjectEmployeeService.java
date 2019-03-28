package com.maven.pablo.reportingtool.Service;

import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;

import java.util.List;
import java.util.Set;

public interface IProjectEmployeeService {

    // GETTING LIST OF USERS ACTIVE IN SOME PROJECT
    Set<Employee> getUsersSetFromProjectByNumber(String projectNumber);
    Set<Employee> getUsersSetFromProject(Project project);

    // GETTING SPECIFIED USERS PROJECT LIST
    List<Project> getListOfProjectsOfUser(Employee employee);
    List<Project> listOfProjectsByUserId(String userId);


    void addUserToTheProject(String projectNumber, String userId);
    void updateUserSetInProject(String projectNumber, Set<Employee> set);
}
