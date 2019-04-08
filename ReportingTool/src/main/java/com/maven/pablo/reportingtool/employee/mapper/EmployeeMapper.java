package com.maven.pablo.reportingtool.employee.mapper;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.entity.Employee;

import java.util.List;


public interface EmployeeMapper {


    EmployeeDto convertToDto(Employee employee);
    List<EmployeeDto> convertToDto(List<Employee> employees);
    Employee newEmployeeFromDto(EmployeeDto employeeDto);
    EmployeeDto emptyEmployeeDto();

}
