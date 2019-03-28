package com.maven.pablo.reportingtool.Service;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Repository.ProjectRepository;
import com.maven.pablo.reportingtool.Repository.EmployeeRepository;
import com.maven.pablo.reportingtool.Service.Response.ProjectInfo;
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
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getListOfOpenProjects() {
        return projectRepository.findOpenedProjects();
    }

    @Override
    public List<Project> getListOfClosedProjects() {
        return projectRepository.findClosedProjects();
    }

    @Override
    public List<Project> listOfProjectsWithBudgetHigher(int bot) {
        return projectRepository.findProjectsWithBudgetHigherThan(bot);
    }

    @Override
    public List<Project> listOfProjectsWithBudgetLower(int top) {
        return projectRepository.findProjectsWithBudgetLowerThan(top);
    }

    @Override
    public List<Project> listOfProjectsWithBudgetBetween(int bot, int top) {
        return projectRepository.findProjectsWithBudgetBetween(bot,top);
    }

    @Override
    public List<Project> listOfProjetsWithNameContaining(String name) {
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
    public ProjectInfo convertSingleProjectIntoResponse(Project project) {
        return null;
    }

    @Override
    public List<ProjectInfo> convertListOfProjectsIntoResponse(List<Project> projectList) {
        return projectList.stream().map(ProjectInfo::new).collect(Collectors.toList());
    }
}

