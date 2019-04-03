package com.maven.pablo.reportingtool.Repository;
import com.maven.pablo.reportingtool.Service.Key.ProjectEmployeeKey;
import com.maven.pablo.reportingtool.Entity.ProjectHours;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectHoursRepository extends CrudRepository<ProjectHours, ProjectEmployeeKey> {


   // List<ProjectHours> findAllHoursOfProject(String projectId);

   // List<ProjectHours> findAllHoursOfEmployee(String projectId);

   //List<ProjectHours> findAllHoursOfEmployeeInProject(String projectId, String employeeId);
}
