package com.maven.pablo.reportingtool.mapper;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import org.springframework.stereotype.Component;

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


}


