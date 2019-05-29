package com.maven.pablo.reportingtool.mapper.impl;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import org.springframework.stereotype.Component;

@Component("myEmployeeMapper")
public class MyEmployeeMapper implements MyMapper<Employee,EmployeeDto> {

    @Override
    public Employee newInstanceFromDto(EmployeeDto dtoObject) {
        return null;
    }

    @Override
    public EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setId(employee.getId());
        employeeDto.setRole(employee.getRole().name());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }


}


