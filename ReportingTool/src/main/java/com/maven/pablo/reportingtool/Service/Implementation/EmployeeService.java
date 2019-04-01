package com.maven.pablo.reportingtool.Service.Implementation;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Repository.EmployeeRepository;
import com.maven.pablo.reportingtool.Service.Interface.IEmployeeService;
import com.maven.pablo.reportingtool.Service.Response.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
        return employeeRepository.getEmployeeByEmailLike(email);
    }

    @Override
    public Collection<Employee> collectionOfAllEmployees() {
        return employeeRepository.collectionOfAllEmployees();
    }

    @Override
    public Set<String> getSetOfAllEmployeesIds() {
        return employeeRepository.collectionOfAllEmployees().stream().map(Employee::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSetOfAllEmployeesNames() {
        return employeeRepository.collectionOfAllEmployees().stream().map(Employee::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSetOfAllEmployeesEmails() {
        return employeeRepository.collectionOfAllEmployees().stream().map(Employee::getEmail)
                .collect(Collectors.toSet());
    }

    @Override
    public void addProjectToEmployeeById(String employeeId, Project project) {
        Employee employee = employeeRepository.getEmployeeOfId(employeeId);
        Set<Project> projects = employee.getProjects();
        projects.add(project);
        employee.setProjects(projects);
        employeeRepository.save(employee);
    }

    @Override
    public void removeProjectFromEmployeeById(String employeeId, Project project) {
        Employee employee = employeeRepository.getEmployeeOfId(employeeId);
        Set<Project> projects = employee.getProjects();
        projects.remove(project);
        employee.setProjects(projects);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeInfo> allEmployeesAsResponse(Collection<Employee> employees) {
        return employees.stream().map(EmployeeInfo::new).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeFromResponse(EmployeeInfo info) {
        return employeeRepository.getEmployeeOfId(info.getId());
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
