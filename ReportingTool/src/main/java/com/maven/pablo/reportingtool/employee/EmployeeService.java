package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import java.util.Collection;

public interface EmployeeService {

    Employee findById(String id);
    Employee findByEmail(String email);

    Collection<Employee> findAll();
    Collection<Employee> findLeaders();


    void saveInRepository(Employee employee);
    void deleteFromRepository(Employee employee);

}
