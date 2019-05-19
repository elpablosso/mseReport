package com.maven.pablo.reportingtool.report.implementation;

import com.maven.pablo.reportingtool.employee.enums.Department;
import com.maven.pablo.reportingtool.report.ReportService;
import com.maven.pablo.reportingtool.report.dto.ReportDto;
import com.maven.pablo.reportingtool.report.dto.ReportFindForm;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.entity.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> findByEmployeeId(String employeeId) {
        return reportRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Report> findByProjectNumber(String projectNumber) {
        return reportRepository.findByProjectNumber(projectNumber);
    }

    @Override
    public List<Report> findByDepartment(Department department) {
        return reportRepository.findByDepartment(department);
    }

    @Override
    public List<Report> findByForm(ReportFindForm findForm) {

        List<Report> reportsOfUser = findByEmployeeId(findForm.getEmployee());
        System.out.println(reportsOfUser.size());

        if(!findForm.getProject().isEmpty()){
            List<Report> filteredByProject = findByProjectNumber(findForm.getProject());
            reportsOfUser = reportsOfUser.stream().filter(filteredByProject::contains).collect(Collectors.toList());
            System.out.println("PROJECT, LIST SIZE"+reportsOfUser.size());
        }
        if(!findForm.getDepartmentName().isEmpty()){
            Department department = Department.valueOf(findForm.getDepartmentName());
            List<Report> filteredByDepartment = findByDepartment(department);
            reportsOfUser = reportsOfUser.stream().filter(filteredByDepartment::contains).collect(Collectors.toList());
            System.out.println("DEPARTMENT, LIST SIZE"+reportsOfUser.size());
        }
        if(findForm.getDateFrom()!=null || findForm.getDateTo()!=null){
            LocalDate dateFrom =findForm.getDateFrom();
            LocalDate dateTo = findForm.getDateTo();

            if(dateFrom==null){dateFrom = LocalDate.of(2000,1,1);}
            if(dateTo==null){dateTo = LocalDate.of(2000,1,1);}

            List<Report> filteredByDate = findByDateBetween(dateFrom,dateTo);
            reportsOfUser = reportsOfUser.stream().filter(filteredByDate::contains).collect(Collectors.toList());
        }

        return reportsOfUser;
    }

    @Override
    public List<Report> findByDateBetween(LocalDate dateFrom, LocalDate dateTo) {
        return reportRepository.findByDateBetween(dateFrom,dateTo);
    }
}
