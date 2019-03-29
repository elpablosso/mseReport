package com.maven.pablo.reportingtool.Service.Implementation;

import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Repository.EmployeeRepository;
import com.maven.pablo.reportingtool.Service.Interface.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeOfId(id);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return null;
    }

    @Override
    public void saveEmployeeInRepository(Employee employee) {
        employeeRepository.save(employee);
    }
}
