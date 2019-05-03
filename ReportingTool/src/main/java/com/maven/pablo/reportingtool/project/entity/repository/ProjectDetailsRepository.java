package com.maven.pablo.reportingtool.project.entity.repository;

import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Integer> {

    List<ProjectDetails> findAll();
    List<ProjectDetails> findByEmployeeId(String employeeId);
    List<ProjectDetails> findByProjectNumber(String projectNumber);
    ProjectDetails findByEmployeeIdAndProjectNumber(String employeeId, String projectNumber);

}
