package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.enums.Role;
import com.maven.pablo.reportingtool.exceptions.EmployeeNotFoundException;
import java.util.List;

public interface EmployeeService {

    Employee findById(String id) throws EmployeeNotFoundException;
    Employee findByEmail(String email) throws EmployeeNotFoundException;
    Employee findByUsername(String username) throws EmployeeNotFoundException;
    Employee findByName(String name) throws EmployeeNotFoundException;

    List<Employee> findAll();
    List<Employee> findByRole(Role role);

    void saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);

}
