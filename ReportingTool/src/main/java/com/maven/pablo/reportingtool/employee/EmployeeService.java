package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee findById(String id);
    Employee findByEmail(String email);
    Employee findByUsername(String username);
    Employee findByName(String name);

    Collection<Employee> findAll();
    Collection<Employee> findLeaders();


    void saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);

}
