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
public class MyEmployeeService implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public MyEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Collection<Employee> findLeaders() {
        return employeeRepository.findByRole("LEADER");
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

        @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @Override
    public void saveInRepository(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteFromRepository(Employee employee) {
        employeeRepository.delete(employee);
    }

}