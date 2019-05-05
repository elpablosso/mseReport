package com.maven.pablo.reportingtool.report.mapper;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.ReportDto;
import java.util.List;

public interface ReportMapper {

    ReportDto newReportFromDto(Report report);
    List<ReportDto> convertToDto(List<Report> reports);
    Report convertToDto(ReportDto reportDto);


}
