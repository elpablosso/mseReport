package com.maven.pablo.reportingtool.Service.Response.EmployeeMapper;

import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Service.Response.EmployeeDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public List<String> projectsIds(List<Project> projects) {
        return projects.stream().map(Project::getNumber).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto employeeToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        //employeeDto.setBonus(employee.getBonus());
        //employeeDto.setSalary(employee.getSalary());
        //employeeDto.setProjectIds(projectsIds(employee.getProjects()));
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> listOfEmployeesToDto(List<Employee> employees) {
        return employees.stream().map(this::employeeToDto).collect(Collectors.toList());
    }

    @Override
    public Employee newEmployeeFromDto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        //employee.setBonus(employeeDto.getBonus());
        //employee.setSalary(employeeDto.getSalary());
        //employee.setProjects(new ArrayList<>());
        return employee;
    }
}
