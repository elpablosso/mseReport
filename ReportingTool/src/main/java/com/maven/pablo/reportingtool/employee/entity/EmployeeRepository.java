package com.maven.pablo.reportingtool.employee.entity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;


public interface EmployeeRepository extends CrudRepository<Employee,String> {


    Collection<Employee> findAll();
    Collection<Employee> findByRole(String role);

    Optional<Employee> findById(String id);
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByUsername(String username);

}
