package com.maven.pablo.reportingtool.employee.entity;
import com.maven.pablo.reportingtool.employee.enums.Role;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends CrudRepository<Employee,String> {

    List<Employee> findAll();
    List<Employee> findByRole(Role role);

    Optional<Employee> findById(String id);
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByName(String name);
    Optional<Employee> findByUsername(String username);

}
