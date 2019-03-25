package com.pablo.application.repository;

import com.pablo.application.entity.department.DepartmentKey;
import com.pablo.application.entity.department.ProjectDepartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDepartmentRepository extends CrudRepository<ProjectDepartment,String> {

    @Query("SELECT p FROM ProjectDepartment p WHERE p.key.userId= ?1")
    List<ProjectDepartment> listOfDepartmentByUserId(String userId);

    @Query("SELECT p FROM ProjectDepartment p WHERE p.key.projectNumber=?1")
    List<ProjectDepartment> listOfDepartmentByProjectNumber(String projectNumber);

    @Query("SELECT p FROM ProjectDepartment p WHERE p.key.userId=?1 and p.key.projectNumber=?2")
    List<ProjectDepartment> listOfDepartmentByUserIdAndProjectNumber(String userId, String projectNumber);

}
