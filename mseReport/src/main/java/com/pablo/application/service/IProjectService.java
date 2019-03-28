package com.pablo.application.service;

import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.user.User;

import java.util.List;

public interface IProjectService {

    /// LISTS OF PROJECTS ///////////////////////

    // RETURN LIST OF ALL AVAIBLE PROJECTS
    List<ProjectInfo> getListOfAllProjects();

    // RETURN LIST OF ALL PROJECTS WITH SPECIFIED USER
    List<ProjectInfo> getListOfProjectsOfUser(User user);

    // RETURN LIST OF PROJECTS WHICH ARE STILL OPEN
    List<ProjectInfo> getListOfOpenProjects();

    //RETURN LIST OF CLOSED PROJECTS
    List<ProjectInfo> getListOfClosedProjects();

    // RETURN LIST OF PROJECTS WITH BUDGET HIGHER OR EQUALS
    List<ProjectInfo> listOfProjectsWithBudgetHigher(int bot);

    // RETURN LIST OF PROJECTS WITH BUDGET LOWER OR EQUALS
    List<ProjectInfo> listOfProjectsWithBudgetLower(int high);

    // RETURN LIST OF PROJECTS WITH BUDGET BETWEEN
    List<ProjectInfo> listOfProjectsWithBudgetBetween(int bot, int high);

    // RETURN LIST OF PROJECTS WITH NAME CONTAINS
    List<ProjectInfo> listOfProjetsWithNameContaining(String name);

    // RETURN LIST OF PROJECTS BY USER ID
    List<ProjectInfo> listOfProjectsByUserId(String userId);

    ////////////////////////////////////////////////


    /// SINGLE PROJECT PICK ////////////////////////

    ProjectInfo findProjectByProjectNumber(String number);


    /// SAVING PROJECT IN REPOSITORY ///

    void saveProjectInRepository(Project project);
    void saveProjectInRepository(ProjectInfo project);


}
