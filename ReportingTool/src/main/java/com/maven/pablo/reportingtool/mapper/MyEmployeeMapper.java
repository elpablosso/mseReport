package com.maven.pablo.reportingtool.mapper;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component("myEmployeeMapper")
public class MyEmployeeMapper implements MyMapper<Employee,EmployeeDto> {

    @Override
    public Employee newInstanceFromDto(EmployeeDto dtoObject) {
        return null;
    }

    @Override
    public EmployeeDto convertToDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getEmail(),
                employee.getName(),
                employee.getRole());
    }

    @Override
    public List<Employee> newInstanceFromDto(Collection<EmployeeDto> dtoObject) {
        return null;
    }

    @Override
    public List<EmployeeDto> convertToDto(Collection<Employee> employees) {
        return employees.stream().map(this::convertToDto).collect(Collectors.toList());
    }

}


