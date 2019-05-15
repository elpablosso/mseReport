package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import com.maven.pablo.reportingtool.report.entity.Report;
import java.math.BigDecimal;
import java.util.List;

public interface ProjectDetailsService {

    boolean exist(String projectId, String employeeId);

    void increaseModelling(Project project, Employee employee, BigDecimal value);
    void increaseDrawings(Project project, Employee employee,  BigDecimal value);
    void increaseDocumentation(Project project, Employee employee, BigDecimal value);
    void increaseCorrespondence(Project project, Employee employee,  BigDecimal value);
    void increaseDepartment(Project project, Employee employee, String departmentName, BigDecimal value);

    ProjectDetails findByProjectNumberAndEmployeeId(String projectNumber, String employeeId);
    ProjectDetails of(Project project, Employee employee);

    void addHoursFromReport(Report report);
    void addHoursFromReport(List<Report> reports);

    void createNewProjectDetails(Project project, Employee employee);
    void save(ProjectDetails projectDetails);
}
