package com.maven.pablo.reportingtool.report.implementation;

import com.maven.pablo.reportingtool.employee.enums.Department;
import com.maven.pablo.reportingtool.report.ReportService;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.entity.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyReportService implements ReportService {

    private ReportRepository reportRepository;

    @Autowired
    public MyReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public void save(List<Report> reports) {
        for(Report report : reports){
            reportRepository.save(report);
        }
    }

    @Override
    public void save(Report report) {
        reportRepository.save(report);
    }

    public List<String> departmentList(){
        List<String> departments = new ArrayList<>();
        for(Department d : Department.values()){
            departments.add(d.toString());
        }
        return departments;
    }

    @Override
    public Collection<Report> findAll() {
        return reportRepository.findAll();
    }
}
