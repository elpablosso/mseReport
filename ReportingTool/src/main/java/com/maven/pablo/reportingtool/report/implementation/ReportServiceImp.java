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
public class ReportServiceImp implements ReportService {

    private ReportRepository reportRepository;

    @Autowired
    public ReportServiceImp(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
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
