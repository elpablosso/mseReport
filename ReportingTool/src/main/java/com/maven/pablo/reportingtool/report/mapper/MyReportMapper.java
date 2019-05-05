package com.maven.pablo.reportingtool.report.mapper;

import com.maven.pablo.reportingtool.report.ReportDto;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyReportMapper implements ReportMapper {

    @Override
    public ReportDto newReportFromDto(Report report) {
        return null;
    }

    @Override
    public List<ReportDto> convertToDto(List<Report> reports) {
        return null;
    }

    @Override
    public Report convertToDto(ReportDto reportDto) {
        return null;
    }

}
