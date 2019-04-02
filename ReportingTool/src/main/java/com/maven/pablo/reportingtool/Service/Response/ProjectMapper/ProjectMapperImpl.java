package com.maven.pablo.reportingtool.Service.Response.ProjectMapper;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Service.Response.ProjectDto;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public List<String> employeesIds(List<Employee> employees) {
        return employees.stream().map(Employee::getId).collect(Collectors.toList());
    }

    @Override
    public ProjectDto projectToDto(Project project) {

        if ( project == null ) {
            return null; }

        ProjectDto projectDto = new ProjectDto();
        projectDto.setNumber(project.getNumber());
        projectDto.setTitle(project.getTitle());
        projectDto.setBudget(project.getBudget());
        projectDto.setClosed(false);
        projectDto.setEmployeesIds(employeesIds(project.getEmployees()));
        return projectDto;
    }

    @Override
    public List<ProjectDto> listOfProjectsToDto(List<Project> projects) {
        return projects.stream().map(this::projectToDto).collect(Collectors.toList());
    }

    @Override
    public Project newProjectFromDto(ProjectDto projectDto) {
        Project project = new Project();
        project.setNumber(projectDto.getNumber());
        project.setTitle(projectDto.getTitle());
        project.setBudget(projectDto.getBudget());
        project.setClosed(false);
        return project;
    }
}
