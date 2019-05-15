package com.maven.pablo.reportingtool.report.mapper;

import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.enums.Department;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.report.ReportDto;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyReportMapper implements ReportMapper {

    private ProjectService projectService;
    private EmployeeService employeeService;

    public MyReportMapper(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @Override
    public Report convertFromDto(ReportDto reportDto) {

        Report report = new Report();
        Project project = projectService.findByNumber(reportDto.getProjectId());
        Employee employee = employeeService.findById(reportDto.getEmployeeId());

        report.setEmployee(employee);
        report.setProject(project);
        report.setDepartment(Department.valueOf(reportDto.getDepartment()));
        report.setDate(LocalDate.now());
        report.setTime(reportDto.getTime());
        report.setAdditionalRange(reportDto.isAdditionalRange());
        report.setDescription(reportDto.getDescription());

        return report;
    }

    @Override
    public List<Report> convertFromDto(List<ReportDto> reports) {
        return reports.stream().map(this::convertFromDto).collect(Collectors.toList());
    }
}
