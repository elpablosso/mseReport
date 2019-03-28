package com.maven.pablo.reportingtool.Service;

import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Entity.User;

import java.util.List;

public interface IProjectService {

    /// LISTS OF PROJECTS ///////////////////////

    // RETURN LIST OF ALL AVAIBLE PROJECTS
    List<Project> getListOfAllProjects();

    // RETURN LIST OF ALL PROJECTS WITH SPECIFIED USER
    List<Project> getListOfProjectsOfUser(User user);

    // RETURN LIST OF PROJECTS WHICH ARE STILL OPEN
    List<Project> getListOfOpenProjects();

    //RETURN LIST OF CLOSED PROJECTS
    List<Project> getListOfClosedProjects();

    // RETURN LIST OF PROJECTS WITH BUDGET HIGHER OR EQUALS
    List<Project> listOfProjectsWithBudgetHigher(int bot);

    // RETURN LIST OF PROJECTS WITH BUDGET LOWER OR EQUALS
    List<Project> listOfProjectsWithBudgetLower(int high);

    // RETURN LIST OF PROJECTS WITH BUDGET BETWEEN
    List<Project> listOfProjectsWithBudgetBetween(int bot, int high);

    // RETURN LIST OF PROJECTS WITH NAME CONTAINS
    List<Project> listOfProjetsWithNameContaining(String name);

    // RETURN LIST OF PROJECTS BY USER ID
    List<Project> listOfProjectsByUserId(String userId);

    ////////////////////////////////////////////////


    Project findProjectByProjectNumber(String number);




    /// SAVING PROJECT IN REPOSITORY ///
    void saveProjectInRepository(Project project);




    //// MODIFING THE PROJECT
    void addUserToTheProject(String projectNumber, String userId);




    /// CONVERTING INTO CONTROLLER RESPONSE ////

    ProjectInfo convertSingleProjectIntoResponse(Project project);
    List<ProjectInfo> convertListOfProjectsIntoResponse(List<Project> projectList);

}
