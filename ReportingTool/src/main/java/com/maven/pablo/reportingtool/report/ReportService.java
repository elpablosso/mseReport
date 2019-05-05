package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public interface ReportService {

    Collection<Report> findAll();

    List<String> departmentList();

}
