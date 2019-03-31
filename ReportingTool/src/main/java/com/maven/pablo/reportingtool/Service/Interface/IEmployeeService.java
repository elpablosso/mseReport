package com.maven.pablo.reportingtool.Service.Interface;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;

import java.util.Collection;
import java.util.Set;


public interface IEmployeeService {

    Employee getEmployeeById(String id);
    Employee getEmployeeByEmail(String email);

    Collection<Employee> collectionOfAllEmployees();
    Set<String> getSetOfAllEmployeesIds();
    Set<String> getSetOfAllEmployeesNames();
    Set<String> getSetOfAllEmployeesEmails();

    void saveEmployeeInRepository(Employee employee);
    void deleteEmployeeFromRepository(Employee employee);
    void deleteEmployeeFromRepositoryById(String employeeId);

    void addProjectToEmployeeById(String employeeId, Project project);
    void removeProjectFromEmployeeById(String employeeId, Project project);


}
