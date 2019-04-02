package com.maven.pablo.reportingtool.Service.Response.ProjectMapper;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Service.Response.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper( ProjectMapper.class );

    @Mapping(source="employees", target = "employeesIds")
    List<String> employeesIds(List<Employee> employees);

    ProjectDto projectToDto(Project project);
    List<ProjectDto> listOfProjectsToDto(List<Project> projects);
    Project newProjectFromDto(ProjectDto projectDto);

}
