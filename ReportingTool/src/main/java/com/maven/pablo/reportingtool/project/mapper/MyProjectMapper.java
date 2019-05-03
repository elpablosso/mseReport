package com.maven.pablo.reportingtool.project.mapper;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.dto.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyProjectMapper implements ProjectMapper{

    @Autowired
    EmployeeService employeeService;

    public MyProjectMapper() {
    }

    @Override
    public Project newProjectFromForm(ProjectForm form) {
        Project project = new Project();

        project.setNumber(form.getNumber());
        project.setBudget(BigDecimal.valueOf(form.getBudget()));
        project.setTitle(form.getTitle());
        Employee employee = employeeService.findById(form.getLeaderId());
        project.setLeader(employee);
        project.setClosed(false);

        return project;
    }

    public Project newProjectFromDto(ProjectDto projectDto){

        return null;
    }

    public ProjectDto convertToDto(Project project){
        return new ProjectDto(project.getNumber(),
                                project.getTitle(),
                                project.getBudget().intValue(),
                                project.isClosed(),
                                project.getLeader().getId());
    }

    public List<ProjectDto> convertToDto(Collection<Project> projects){
        return projects.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Project openNewProject() {
        Project project = new Project();

        return project;
    }
}
