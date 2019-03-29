package com.maven.pablo.reportingtool.Repository;

import com.maven.pablo.reportingtool.Entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,String> {

    @Query("SELECT e FROM Employee e WHERE e.id = ?1")
    Employee getEmployeeOfId(String id);

}
