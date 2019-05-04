package com.maven.pablo.reportingtool.report.implementation;

import com.maven.pablo.reportingtool.employee.enums.Departments;
import com.maven.pablo.reportingtool.report.ReportService;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.entity.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
        for(Departments d : Departments.values()){
            departments.add(d.toString());
        }
        return departments;
    }


    @Override
    public void saveReportPartInRepository(Report report) {
        reportRepository.save(report);
    }

    @Override
    public void deleteReportFromRepository(Report report) {

    }

    @Override
    public void saveListOfReportPartsInRepository(List<Report> reports) {

    }

    @Override
    public List<Report> findAllReports() {
        return null;
    }

    @Override
    public List<Report> findAllReportsOfEmployee(String employeeId) {
        return null;
    }

    @Override
    public List<Report> findAllReportsOfProject(String projectId) {
        return null;
    }

    @Override
    public List<Report> findAllReportsOfEmployeeInProject(String employeeId, String projectId) {
        return null;
    }

    @Override
    public List<Report> findAllReportTimePeroid(LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public List<Report> findAllReportsOfEmployeeTimePeroid(String employeeId, LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public List<Report> findAllReportOfEmployeeInProjectTimePeroid(String employeeId, String projectId, LocalDate from, LocalDate to) {
        return null;
    }
}
