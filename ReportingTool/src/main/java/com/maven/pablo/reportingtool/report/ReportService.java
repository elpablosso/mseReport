package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public interface ReportService {

    void saveReportPartInRepository(Report report);
    void deleteReportFromRepository(Report report);
    void saveListOfReportPartsInRepository(List<Report> reports);

    public List<String> departmentList();

    List<Report> findAllReports();
    List<Report> findAllReportsOfEmployee(String employeeId);
    List<Report> findAllReportsOfProject(String projectId);
    List<Report> findAllReportsOfEmployeeInProject(String employeeId, String projectId);

    List<Report> findAllReportTimePeroid(LocalDate from, LocalDate to);
    List<Report> findAllReportsOfEmployeeTimePeroid(String employeeId, LocalDate from, LocalDate to);
    List<Report> findAllReportOfEmployeeInProjectTimePeroid(String employeeId, String projectId,
                                                            LocalDate from, LocalDate to);

}
