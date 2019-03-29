package com.maven.pablo.reportingtool.Service.Interface;

import com.maven.pablo.reportingtool.Entity.Employee;

public interface IEmployeeService {

    Employee getEmployeeById(String id);
    Employee getEmployeeByEmail(String email);

    void saveEmployeeInRepository(Employee employee);


    /// CONTROLLER RESPONSES

    // List<EmployeeInfo> convertEmployeeListIntoResponse(Collection<Employee> employees);
    // EmployeeInfo convertSingleEmployeeIntoResponse(Employee employee);
}
