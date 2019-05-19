package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import com.maven.pablo.reportingtool.report.entity.Report;
import java.util.List;

public interface ProjectDetailsService {

    void increaseModelling(ProjectDetails projectDetails, Report report);
    void increaseDrawings(ProjectDetails projectDetails, Report report);
    void increaseDocumentation(ProjectDetails projectDetails, Report report);
    void increaseCorrespondence(ProjectDetails projectDetails, Report report);
    void increaseAdditionalHours(ProjectDetails projectDetails, Report report);
    void increaseDepartment(ProjectDetails projectDetails, Report report);

    List<ProjectDetails> findByEmployeeId(String employeeId);
    List<ProjectDetails> findByProjectNumber(String projectNumber);

    ProjectDetails findByProjectNumberAndEmployeeId(String projectNumber, String employeeId);
    ProjectDetails findByProjectAndEmployee(Project project, Employee employee);

    void addHoursFromReport(Report report);
    void addHoursFromReport(List<Report> reports);

    ProjectDetails createNewProjectDetails(Project project, Employee employee);
    void save(ProjectDetails projectDetails);
}
