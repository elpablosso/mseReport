package com.maven.pablo.reportingtool.Repository;
import com.maven.pablo.reportingtool.Entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface EmployeeRepository extends CrudRepository<Employee,String> {

    @Query("SELECT e FROM Employee e WHERE e.id LIKE '%'")
    Collection<Employee> collectionOfAllEmployees();

    @Query("SELECT e FROM Employee e WHERE e.id = ?1")
    Employee getEmployeeOfId(String id);

    @Query("Select e FROM Employee e WHERE e.id LIKE '%' AND e.email LIKE CONCAT('%',:email,'%')")
    Employee getEmployeeByEmailLike(@Param("email")String email);

    @Query("DELETE FROM Employee e WHERE e.id=?1")
    void deleteEmployeeOfId(String id);

}
