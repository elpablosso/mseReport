package com.maven.pablo.reportingtool.mapper;
import com.maven.pablo.reportingtool.employee.enums.Department;
import com.maven.pablo.reportingtool.report.dto.ReportDto;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component("myReportMapper")
@Scope(scopeName = "prototype")
public class MyReportMapper implements MyMapper<Report,ReportDto> {

    @Override
    public Report newInstanceFromDto(ReportDto reportDto) {
        Report report = new Report();

        report.setEmployee(reportDto.getEmployee());
        report.setProject(reportDto.getProject());
        report.setDepartment(Department.valueOf(reportDto.getDepartment()));
        report.setDate(LocalDate.now());
        report.setTime(reportDto.getTime());
        report.setAdditionalRange(reportDto.isAdditionalRange());
        report.setDescription(reportDto.getDescription());

        return report;
    }

    @Override
    public ReportDto convertToDto(Report report) {
        ReportDto reportDto = new ReportDto();

        reportDto.setEmployee(report.getEmployee());
        reportDto.setEmployeeId(report.getEmployee().getId());
        reportDto.setProject(report.getProject());
        reportDto.setProjectId(report.getProject().getNumber());

        reportDto.setDepartment(report.getDepartment().name());
        reportDto.setTime(report.getTime());
        reportDto.setAdditionalRange(report.isAdditionalRange());

        reportDto.setDate(report.getDate());
        reportDto.setDescription(report.getDescription());

        return reportDto;
    }

}
