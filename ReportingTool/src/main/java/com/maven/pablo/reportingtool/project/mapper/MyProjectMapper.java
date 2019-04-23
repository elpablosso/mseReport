package com.maven.pablo.reportingtool.project.mapper;
import com.maven.pablo.reportingtool.project.ProjectDto;
import com.maven.pablo.reportingtool.project.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
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
        project.setTitle(projectDto.getTitle());
        project.setBudget(BigDecimal.valueOf(projectDto.getBudget()));
        return project;
    }

    public ProjectDto convertToDto(Project project){
                return new ProjectDto.Builder(project.getNumber())
                .title(project.getTitle())
                .modelling(project.getModelling().intValue())
                .drawings(project.getDrawings().intValue())
                .documentation(project.getDocumentation().intValue())
                .correspondence(project.getCorrespondence().intValue())
                .additionalHours(project.getAdditionalHours().intValue())
                .budget(project.getBudget().intValue())
                .closed(project.isClosed()).build();
    }

    public List<ProjectDto> convertToDto(Collection<Project> projects){
        return projects.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Project openNewProject() {
        Project project = new Project();
        project.setClosed(false);
        project.setAdditionalHours(BigDecimal.ZERO);
        project.setCorrespondence(BigDecimal.ZERO);
        project.setDrawings(BigDecimal.ZERO);
        project.setModelling(BigDecimal.ZERO);
        project.setDocumentation(BigDecimal.ZERO);
        return project;
    }
}
