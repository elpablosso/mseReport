package com.maven.pablo.reportingtool.Service.Interface;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import java.util.Collection;



public interface IProjectService {

    /// LISTS OF PROJECTS ///////////////////////

    Collection<Project> getListOfAllProjects();
    Collection<Project> getListOfOpenProjects();
    Collection<Project> getListOfClosedProjects();
    Collection<Project> getProjectsWithBudgetHigher(int bot);
    Collection<Project> getProjectsWithBudgetLower(int high);
    Collection<Project> getProjectsWithBudgetBetween(int bot, int high);
    Collection<Project> getProjectsWithNameContaining(String name);

    // SINGLE OBJECT FIND //
    Project findProjectByProjectNumber(String number);


    /// SAVING PROJECT IN REPOSITORY ///
    void saveProjectInRepository(Project project);

    // DELETING
    void removeProjectByNumber(String projectNumber);
    void removeEmployeeFromProject(String projectNumber, Employee employee);


    // CHANGING OBJECTS
    void addEmployeeToProject(String projectNumber, Employee employee);



}
