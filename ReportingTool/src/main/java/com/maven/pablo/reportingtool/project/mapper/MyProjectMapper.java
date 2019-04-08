package com.maven.pablo.reportingtool.project.mapper;
import com.maven.pablo.reportingtool.project.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MyProjectMapper implements ProjectMapper{

    public MyProjectMapper() {
    }

    public Project newProjectFromDto(ProjectDto projectDto){

        Project project = new Project();
        project.setNumber(projectDto.getNumber());

        if(projectDto.getTitle()!=null)
        project.setTitle(projectDto.getTitle());

        if(projectDto.getBudget()!=0)
        project.setBudget(BigDecimal.valueOf(projectDto.getBudget()));

        project.setClosed(false);
        project.setDateStarted(LocalDate.now());

        project.setAdditionalHours(BigDecimal.ZERO);
        project.setCorrespondence(BigDecimal.ZERO);
        project.setDrawings(BigDecimal.ZERO);
        project.setModelling(BigDecimal.ZERO);
        project.setDocumentation(BigDecimal.ZERO);

        return project;
    }

    public ProjectDto convertToDto(Project project){
        return new ProjectDto(
                project.getNumber(),
                project.getDateStarted(),
                project.getTitle(),
                project.getModelling().intValue(),
                project.getCorrespondence().intValue(),
                project.getDocumentation().intValue(),
                project.getDrawings().intValue(),
                project.getBudget().intValue(),
                project.getAdditionalHours().intValue(),
                project.isClosed());
    }

    public List<ProjectDto> convertToDto(Collection<Project> projects){
        ArrayList<ProjectDto> projectDtos = new ArrayList<>();
        for(Project project : projects){
            projectDtos.add(convertToDto(project));
        } return projectDtos;
    }

    @Override
    public ProjectDto emptyDto() {
        return new ProjectDto();
    }
}
