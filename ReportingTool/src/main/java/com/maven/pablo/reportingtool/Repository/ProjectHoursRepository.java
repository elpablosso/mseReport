package com.maven.pablo.reportingtool.repository;
import com.maven.pablo.reportingtool.service.keys.ProjectEmployeeKey;
import com.maven.pablo.reportingtool.entity.ProjectHours;
import org.springframework.data.repository.CrudRepository;

public interface ProjectHoursRepository extends CrudRepository<ProjectHours, ProjectEmployeeKey> {


   // List<ProjectHours> findAllHoursOfProject(String projectId);

   // List<ProjectHours> findAllHoursOfEmployee(String projectId);

   //List<ProjectHours> findAllHoursOfEmployeeInProject(String projectId, String employeeId);
}
