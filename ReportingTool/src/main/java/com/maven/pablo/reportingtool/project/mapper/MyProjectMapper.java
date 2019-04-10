package com.maven.pablo.reportingtool.project.mapper;
import com.maven.pablo.reportingtool.project.ProjectDto;
import com.maven.pablo.reportingtool.project.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyProjectMapper implements ProjectMapper{

    public MyProjectMapper() {
    }

    @Override
    public Project newProjectFromForm(ProjectForm form) {
        Project project = openNewProject();
        project.setNumber(form.getNumber());
        project.setTitle(form.getTitle());
        project.setBudget(BigDecimal.valueOf(form.getBudget()));

        return project;
    }

    public Project newProjectFromDto(ProjectDto projectDto){

        Project project = openNewProject();
        project.setNumber(projectDto.getNumber());

        if(projectDto.getTitle()!=null)
        project.setTitle(projectDto.getTitle());

        if(projectDto.getBudget()!=0)
        project.setBudget(BigDecimal.valueOf(projectDto.getBudget()));

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
        return projects.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Project openNewProject() {
        Project project = new Project();
        project.setClosed(false);
        project.setDateStarted(LocalDate.now());
        project.setAdditionalHours(BigDecimal.ZERO);
        project.setCorrespondence(BigDecimal.ZERO);
        project.setDrawings(BigDecimal.ZERO);
        project.setModelling(BigDecimal.ZERO);
        project.setDocumentation(BigDecimal.ZERO);
        return project;
    }
}
