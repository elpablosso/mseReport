package com.maven.pablo.reportingtool.project.implementation;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.project.ProjectDetailsService;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import com.maven.pablo.reportingtool.project.entity.key.ProjectEmployeeKey;
import com.maven.pablo.reportingtool.project.entity.repository.ProjectDetailsRepository;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MyProjectDetailsService implements ProjectDetailsService {

    private ProjectDetailsRepository projectDetailsRepository;

    @Autowired
    public MyProjectDetailsService(ProjectDetailsRepository projectDetailsRepository) {
        this.projectDetailsRepository = projectDetailsRepository;
    }

    @Override
    public void addHoursFromReport(List<Report> reports) {
        for(Report report : reports){
            addHoursFromReport(report);
        }
    }
    @Override
    public void addHoursFromReport(Report report) {

        Project project = report.getProject();
        Employee employee = report.getEmployee();

        if(!exist(project.getNumber() , employee.getId())) {
            createNewProjectDetails(project, employee);
        }
                increaseDepartment(project, employee,
                report.getDepartment().name(), report.getTime());
    }

    @Override
    public ProjectDetails findByProjectNumberAndEmployeeId(String projectNumber, String employeeId) {
        return projectDetailsRepository.findByProjectNumberAndEmployeeId(projectNumber,employeeId);
    }

    @Override
    public ProjectDetails of(Project project, Employee employee) {
        return findByProjectNumberAndEmployeeId(project.getNumber(),employee.getId());
    }

    @Override
    public boolean exist(String projectId, String employeeId) {
        ProjectDetails projectDetails = findByProjectNumberAndEmployeeId(projectId, employeeId);
        if (projectDetails == null) return false;
        else return true;
    }

    @Override
    public void increaseModelling(Project project, Employee employee, BigDecimal value) {
        ProjectDetails projectDetails = of(project, employee);
        if (projectDetails != null) {
            projectDetails.setModelling(projectDetails.getModelling().add(value));
        }
    }

    @Override
    public void increaseDrawings(Project project, Employee employee, BigDecimal value) {
        ProjectDetails projectDetails = of(project, employee);
        if (projectDetails != null) {
            projectDetails.setDrawings(projectDetails.getDrawings().add(value));
        }
    }

    @Override
    public void increaseDocumentation(Project project, Employee employee, BigDecimal value) {
        ProjectDetails projectDetails = of(project, employee);
        if (projectDetails != null) {
            projectDetails.setDocumentation(projectDetails.getDocumentation().add(value));
        }
    }

    @Override
    public void increaseCorrespondence(Project project, Employee employee, BigDecimal value) {
        ProjectDetails projectDetails = of(project, employee);
        if (projectDetails != null) {
            projectDetails.setCorrespondence(projectDetails.getCorrespondence().add(value));
        }
    }

    @Override
    public void increaseDepartment(Project project, Employee employee, String departmentName, BigDecimal value) {

        switch (departmentName) {
            case "MODELLING":
                increaseModelling(project, employee, value);
                break;
            case "DRAWINGS":
                increaseDrawings(project, employee, value);
                break;
            case "DOCUMENTATION":
                increaseDocumentation(project, employee, value);
                break;
            case "CORRESPONDENCE":
                increaseCorrespondence(project, employee, value);
                break;
        }
    }

    @Override
    public void save(ProjectDetails projectDetails) {
        projectDetailsRepository.save(projectDetails);
    }

    @Override
    public void createNewProjectDetails(Project project, Employee employee) {

        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setEmployee(employee);
        projectDetails.setProject(project);

        ProjectEmployeeKey projectEmployeeKey = new ProjectEmployeeKey(employee.getId(),project.getNumber());
        projectDetails.setProjectEmployeeKey(projectEmployeeKey);

        projectDetails.setModelling(BigDecimal.ZERO);
        projectDetails.setDrawings(BigDecimal.ZERO);
        projectDetails.setDocumentation(BigDecimal.ZERO);
        projectDetails.setCorrespondence(BigDecimal.ZERO);
        projectDetails.setAdditionalHours(BigDecimal.ZERO);

        save(projectDetails);
    }

}
