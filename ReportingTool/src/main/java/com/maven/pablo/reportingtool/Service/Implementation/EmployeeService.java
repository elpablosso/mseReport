package com.maven.pablo.reportingtool.service.implementation;
import com.maven.pablo.reportingtool.entity.Employee;
import com.maven.pablo.reportingtool.entity.Project;
import com.maven.pablo.reportingtool.repository.EmployeeRepository;
import com.maven.pablo.reportingtool.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService implements IEmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeOfId(id);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.getEmployeeByEmailLike(email);
    }

    @Override
    public Collection<Employee> collectionOfAllEmployees() {
        return employeeRepository.collectionOfAllEmployees();
    }

    @Override
    public List<String> getListOfAllEmployeesIds() {
        return employeeRepository.collectionOfAllEmployees().stream().map(Employee::getId)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getListOfAllEmployeesNames() {
        return employeeRepository.collectionOfAllEmployees().stream().map(Employee::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getListOfAllEmployeesEmails() {
        return employeeRepository.collectionOfAllEmployees().stream().map(Employee::getEmail)
                .collect(Collectors.toList());
    }

    @Override
    public void addProjectToEmployeeById(String employeeId, Project project) {
        Employee employee = employeeRepository.getEmployeeOfId(employeeId);
        List<Project> projects = employee.getProjects();
        projects.add(project);
        employee.setProjects(projects);
        employeeRepository.save(employee);
    }

    @Override
    public void removeProjectFromEmployeeById(String employeeId, Project project) {
        Employee employee = employeeRepository.getEmployeeOfId(employeeId);
        List<Project> projects = employee.getProjects();
        projects.remove(project);
        employee.setProjects(projects);
        employeeRepository.save(employee);
    }

    @Override
    public void saveEmployeeInRepository(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeFromRepository(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteEmployeeFromRepositoryById(String employeeId) {
        employeeRepository.deleteEmployeeOfId(employeeId);
    }


}
