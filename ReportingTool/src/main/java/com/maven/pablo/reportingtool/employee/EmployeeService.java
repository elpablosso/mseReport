package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.exceptions.EmployeeNotFoundException;
import com.maven.pablo.reportingtool.report.entity.Report;

import java.util.Collection;

public interface EmployeeService {

    Employee findById(String id);
    Employee findByEmail(String email);
    Employee findByUsername(String username);
    Employee findByName(String name);

    Collection<Employee> findAll();
    Collection<Employee> findLeaders();

    void addUnreadReport(Collection<Report> reports);
    void addUnreadReport(Report report);
    void markReportAsRead(Report report);
    void markAllReportsAsRead(Employee employee);

    void saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);

}
