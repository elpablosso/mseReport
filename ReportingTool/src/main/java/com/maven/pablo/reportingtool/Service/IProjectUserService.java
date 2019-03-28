package com.maven.pablo.reportingtool.Service;

import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Entity.User;

import java.util.List;
import java.util.Set;

public interface IProjectUserService {

    // GETTING LIST OF USERS ACTIVE IN SOME PROJECT
    Set<User> getUsersSetFromProjectByNumber(String projectNumber);
    Set<User> getUsersSetFromProject(Project project);

    // GETTING SPECIFIED USERS PROJECT LIST
    List<Project> getListOfProjectsOfUser(User user);
    List<Project> listOfProjectsByUserId(String userId);


    void addUserToTheProject(String projectNumber, String userId);
    void updateUserSetInProject(String projectNumber, Set<User> set);
}
