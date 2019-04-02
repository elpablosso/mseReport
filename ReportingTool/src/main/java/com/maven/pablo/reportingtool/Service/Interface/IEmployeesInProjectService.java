package com.maven.pablo.reportingtool.Service.Interface;
import com.maven.pablo.reportingtool.Entity.Employee;
import java.util.List;


public interface IEmployeesInProjectService {

    List<Employee> employeesInProjectByNumber(String projectNumber);
    List<String> employeesInProjectByNumberAsString(String projectNumber);

    void addEmployeeToProjectById(String projectNumber, String employeeId);
    void removeEmployeeFromProjectById(String projectNumber, String employeeId);

}
