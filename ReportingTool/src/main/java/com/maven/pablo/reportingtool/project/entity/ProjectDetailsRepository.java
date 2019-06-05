package com.maven.pablo.reportingtool.project.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Integer> {

    List<ProjectDetails> findAll();
    List<ProjectDetails> findByEmployeeId(String employeeId);
    List<ProjectDetails> findByProjectNumber(String projectNumber);
    ProjectDetails findByProjectNumberAndEmployeeId(String projectNumber, String employeeId);

}
