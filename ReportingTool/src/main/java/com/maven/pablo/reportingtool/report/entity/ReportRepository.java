package com.maven.pablo.reportingtool.report.entity;
import com.maven.pablo.reportingtool.employee.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Integer> {

    Optional<Report> findById(Integer id);
    Report findByEmployeeIdAndProjectNumber(String employeeId, String projectNumber);
    List<Report> findByEmployeeId(String employeeId);
    List<Report> findByProjectNumber(String projectNumber);
    List<Report> findByDateBetween(LocalDate dateFrom, LocalDate dateTo);
    List<Report> findByDepartment(Department department);
}
