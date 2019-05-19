package com.maven.pablo.reportingtool.project.implementation;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.project.ProjectDetailsService;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import com.maven.pablo.reportingtool.project.entity.ProjectDetailsRepository;
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

        ProjectDetails projectDetails = findByProjectAndEmployee(project,employee);
        if(projectDetails==null){projectDetails = createNewProjectDetails(project,employee);}
        increaseDepartment(projectDetails,report);
        if(report.isAdditionalRange()){ increaseAdditionalHours(projectDetails,report);}
        save(projectDetails);
    }

    @Override
    public ProjectDetails findByProjectNumberAndEmployeeId(String projectNumber, String employeeId) {
        return projectDetailsRepository.findByProjectNumberAndEmployeeId(projectNumber,employeeId);
    }

    @Override
    public ProjectDetails findByProjectAndEmployee(Project project, Employee employee) {
        return findByProjectNumberAndEmployeeId(project.getNumber(),employee.getId());
    }

    @Override
    public void increaseModelling(ProjectDetails projectDetails, Report report) {
            projectDetails.setModelling(projectDetails.getModelling().add(report.getTime()));
    }

    @Override
    public void increaseDrawings(ProjectDetails projectDetails, Report report) {
            projectDetails.setDrawings(projectDetails.getDrawings().add(report.getTime()));
    }

    @Override
    public void increaseDocumentation(ProjectDetails projectDetails, Report report) {
            projectDetails.setDocumentation(projectDetails.getDocumentation().add(report.getTime()));
    }

    @Override
    public void increaseCorrespondence(ProjectDetails projectDetails, Report report) {
        projectDetails.setCorrespondence(projectDetails.getCorrespondence().add(report.getTime()));
    }

    @Override
    public void increaseAdditionalHours(ProjectDetails projectDetails, Report report) {
        projectDetails.setAdditionalHours(projectDetails.getAdditionalHours().add(report.getTime()));
    }

    @Override
    public void increaseDepartment(ProjectDetails projectDetails, Report report) {

        switch (report.getDepartment()) {
            case MODELLING:
                increaseModelling(projectDetails, report);
                break;
            case DRAWINGS:
                increaseDrawings(projectDetails, report);
                break;
            case DOCUMENTATION:
                increaseDocumentation(projectDetails, report);
                break;
            case CORRESPONDENCE:
                increaseCorrespondence(projectDetails, report);
                break;
        }
    }

    @Override
    public void save(ProjectDetails projectDetails) {
        projectDetailsRepository.save(projectDetails);
    }

    @Override
    public ProjectDetails createNewProjectDetails(Project project, Employee employee) {

        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setProject(project);
        projectDetails.setEmployee(employee);

        projectDetails.setModelling(BigDecimal.ZERO);
        projectDetails.setDrawings(BigDecimal.ZERO);
        projectDetails.setDocumentation(BigDecimal.ZERO);
        projectDetails.setCorrespondence(BigDecimal.ZERO);
        projectDetails.setAdditionalHours(BigDecimal.ZERO);

        return projectDetails;
    }

    @Override
    public List<ProjectDetails> findByEmployeeId(String employeeId) {
        return projectDetailsRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<ProjectDetails> findByProjectNumber(String projectNumber) {
        return projectDetailsRepository.findByProjectNumber(projectNumber);
    }
}
