package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee findById(String id);
    Employee findByEmail(String email);

    Collection<Employee> findAll();
    List<String> listOfAllIds();
    List<String> listOfAllNames();
    List<String> listOfAllEmails();

    void saveInRepository(Employee employee);
    void deleteFromRepository(Employee employee);
    void deleteFromRepository(String employeeId);

}
