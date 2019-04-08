package com.maven.pablo.reportingtool.employee.implementation;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmailContaining(email).orElse(null);
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<String> listOfAllIds() {
        return findAll().stream().map(Employee::getId).
                collect(Collectors.toList());
    }

    @Override
    public List<String> listOfAllNames() {
        return findAll().stream().map(Employee::getName).
                collect(Collectors.toList());
    }

    @Override
    public List<String> listOfAllEmails() {
        return findAll().stream().map(Employee::getEmail).
                collect(Collectors.toList());
    }

    @Override
    public void saveInRepository(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteFromRepository(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteFromRepository(String employeeId) {
            Employee employee = employeeRepository.findById(employeeId).orElse(null);
            employeeRepository.delete(employee);
    }
}
