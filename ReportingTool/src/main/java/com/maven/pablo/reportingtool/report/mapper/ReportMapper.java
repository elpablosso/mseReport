package com.maven.pablo.reportingtool.report.mapper;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.ReportDto;
import java.util.List;

public interface ReportMapper {

    Report convertFromDto(ReportDto reportDto);
    List<Report> convertFromDto(List<ReportDto> reports);


}
