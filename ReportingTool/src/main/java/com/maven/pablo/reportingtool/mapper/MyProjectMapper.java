package com.maven.pablo.reportingtool.mapper;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component("myProjectMapper")
public class MyProjectMapper implements MyMapper<Project,ProjectDto> {

    public MyProjectMapper() {
    }

    @Override
    public Project newInstanceFromDto(ProjectDto projectDto) {
        Project project = new Project();
        project.setNumber(projectDto.getNumber());
        project.setBudget(BigDecimal.valueOf(projectDto.getBudget()));
        project.setTitle(projectDto.getTitle());
        Employee leader = projectDto.getLeader();
        project.setLeader(leader);
        return project;
    }


    public ProjectDto convertToDto(Project project){
        ProjectDto projectDto = new ProjectDto();
        projectDto.setNumber(project.getNumber());
        projectDto.setTitle(project.getTitle());
        projectDto.setLeader(project.getLeader());
        projectDto.setLeaderId(project.getLeader().getId());
        projectDto.setBudget(project.getBudget().intValue());

        return projectDto;
    }


}
