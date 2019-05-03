package com.maven.pablo.reportingtool.employee.mapper;

import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyEmployeeMapper implements EmployeeMapper {

    @Override
    public EmployeeDto convertToDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getEmail(),
                employee.getName(),
                employee.getRole());}

    @Override
    public List<EmployeeDto> convertToDto(Collection<Employee> employees) {
        return employees.stream().map(this::convertToDto).collect(Collectors.toList()) ;}

    @Override
    public Employee newEmployeeFromDto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }

    @Override
    public EmployeeDto emptyEmployeeDto() {
        return new EmployeeDto();
    }
}
