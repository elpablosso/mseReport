package com.maven.pablo.reportingtool.employee.implementation;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.entity.EmployeeRepository;
import com.maven.pablo.reportingtool.employee.enums.Role;
import com.maven.pablo.reportingtool.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyEmployeeService implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public MyEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findByEmail(String email) throws EmployeeNotFoundException {
        return employeeRepository.findByEmail(email).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findByRole(Role role) {
        return employeeRepository.findByRole(role);
    }

    @Override
    public Employee findById(String id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByName(String name) throws EmployeeNotFoundException {
        return employeeRepository.findByName(name).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Employee findByUsername(String username) throws EmployeeNotFoundException {
        return employeeRepository.findByUsername(username).orElseThrow(EmployeeNotFoundException::new);
    }
}
