package com.maven.pablo.reportingtool.Service.Response.EmployeeMapper;

import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Service.Response.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );

    @Mapping(source="projects", target = "projectIds")
    List<String> projectsIds(List<Project> projects);

    EmployeeDto employeeToDto(Employee employee);
    List<EmployeeDto> listOfEmployeesToDto(List<Employee> employees);
    Employee newEmployeeFromDto(EmployeeDto employeeDto);

}
