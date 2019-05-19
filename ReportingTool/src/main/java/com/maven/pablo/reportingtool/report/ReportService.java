package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.enums.Department;
import com.maven.pablo.reportingtool.report.dto.ReportFindForm;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public interface ReportService {

    List<Report> findAll();
    List<Report> findByEmployeeId(String employeeId);
    List<Report> findByProjectNumber(String projectNumber);
    List<Report> findByDepartment(Department department);
    List<Report> findByDateBetween(LocalDate dateFrom, LocalDate dateTo);
    List<Report> findByForm(ReportFindForm findForm);


    List<String> departmentList();

    void save(List<Report> reports);
    void save(Report report);
}
