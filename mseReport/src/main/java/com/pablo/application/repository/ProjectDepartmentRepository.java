package com.pablo.application.repository;

import com.pablo.application.entity.department.DepartmentKey;
import com.pablo.application.entity.department.ProjectDepartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDepartmentRepository extends CrudRepository<ProjectDepartment,String> {

    ProjectDepartment findByProjectNumber(String projectNumber);
    ProjectDepartment findByDepartmentKey(DepartmentKey departmentKey);
    ProjectDepartment findByProjectNumberAndUserId(String projectNumber, String userId);

}
