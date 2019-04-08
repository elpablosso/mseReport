package com.maven.pablo.reportingtool.employee.entity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;


public interface EmployeeRepository extends CrudRepository<Employee,String> {


    Collection<Employee> findAll();
    Optional<Employee> findById(String id);
    Optional<Employee> findByUsername(String username);
    Optional<Employee> findByEmailContaining(String email);

}
