package com.pablo.application.service;
import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.user.User;
import com.pablo.application.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@ComponentScan("com/pablo/application/entity")
@Service
public class ProjectService implements IProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectInfo> getListOfAllProjects() {
        List<Project> allProjects = (List<Project>) projectRepository.findAll();
        return allProjects.stream()
                .map(ProjectInfo::new).collect(Collectors.toList());
    }

    @Override
    public List<ProjectInfo> getListOfProjectsOfUser(User user) {
        return null;
    }

    @Override
    public List<ProjectInfo> getListOfOpenProjects() {
        return null;
    }

    @Override
    public List<ProjectInfo> getListOfClosedProjects() {
        return null;
    }

    @Override
    public List<ProjectInfo> listOfProjectsWithBudgetHigher(int bot) {
        return null;
    }

    @Override
    public List<ProjectInfo> listOfProjectsWithBudgetLower(int high) {
        return null;
    }

    @Override
    public List<ProjectInfo> listOfProjectsWithBudgetBetween(int bot, int high) {
        return null;
    }

    @Override
    public List<ProjectInfo> listOfProjetsWithNameContaining(String name) {
        return null;
    }

    @Override
    public List<ProjectInfo> listOfProjectsByUserId(String userId) {
        return null;
    }

    @Override
    public ProjectInfo findProjectByProjectNumber(String number) {
        return null;
    }

    @Override
    public void saveProjectInRepository(Project project) {

    }

    @Override
    public void saveProjectInRepository(ProjectInfo project) {

    }
}