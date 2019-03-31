package com.maven.pablo.reportingtool.Service.Interface;

import com.maven.pablo.reportingtool.Entity.Employee;
import java.util.Set;

public interface IEmployeesInProjectService {

    Set<Employee> employeesInProjectByNumber(String projectNumber);
    Set<String> employeesInProjectByNumberAsString(String projectNumber);

    void addEmployeeToProjectById(String projectNumber, String employeeId);
    void removeEmployeeFromProjectById(String projectNumber, String employeeId);

}