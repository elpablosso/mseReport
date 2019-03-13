package com.pablo.application.project.department;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDepartmentRepository extends CrudRepository<ProjectDepartment,Integer> {

    ProjectDepartment findByProjectNumber(String projectNumber);

}
