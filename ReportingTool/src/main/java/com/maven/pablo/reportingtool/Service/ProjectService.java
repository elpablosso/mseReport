package com.maven.pablo.reportingtool.Service;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Entity.User;
import com.maven.pablo.reportingtool.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getListOfAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public List<Project> getListOfProjectsOfUser(User user) {
        return null;
    }

    @Override
    public List<Project> getListOfOpenProjects() {
        return null;
    }

    @Override
    public List<Project> getListOfClosedProjects() {
        return null;
    }

    @Override
    public List<Project> listOfProjectsWithBudgetHigher(int bot) {
        return null;
    }

    @Override
    public List<Project> listOfProjectsWithBudgetLower(int high) {
        return null;
    }

    @Override
    public List<Project> listOfProjectsWithBudgetBetween(int bot, int high) {
        return null;
    }

    @Override
    public List<Project> listOfProjetsWithNameContaining(String name) {
        return null;
    }

    @Override
    public List<Project> listOfProjectsByUserId(String userId) {
        return null;
    }

    @Override
    public Project findProjectByProjectNumber(String number) {
        return null;
    }

    @Override
    public void saveProjectInRepository(Project project) {

    }

    @Override
    public void addUserToTheProject(String projectNumber, String userId) {

    }

    @Override
    public ProjectInfo convertSingleProjectIntoResponse(Project project) {
        return null;
    }

    @Override
    public List<ProjectInfo> convertListOfProjectsIntoResponse(List<Project> projectList) {
        return projectList.stream().map(ProjectInfo::new).collect(Collectors.toList());
    }
}

