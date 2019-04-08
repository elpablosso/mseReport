package com.maven.pablo.reportingtool.employee.mapper;

import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyEmployeeMapper implements EmployeeMapper {

    @Override
    public EmployeeDto convertToDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getEmail(),
                employee.getName(),
                employee.getRole().toString());
    }

    @Override
    public List<EmployeeDto> convertToDto(List<Employee> employees) {
        return null;
    }

    @Override
    public Employee newEmployeeFromDto(EmployeeDto employeeDto) {
        return null;
    }
}
