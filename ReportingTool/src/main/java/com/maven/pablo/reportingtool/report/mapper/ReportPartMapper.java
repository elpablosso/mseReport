package com.maven.pablo.reportingtool.report.mapper;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.ReportDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
@Mapper
public interface ReportPartMapper {

    ReportPartMapper INSTANCE = Mappers.getMapper( ReportPartMapper.class );

    ReportDto reportPartToDto(Report report);
    List<ReportDto> listOfReportPartsToDto(List<Report> reports);
    Report newReportPartFromDto(ReportDto reportDto);

}
