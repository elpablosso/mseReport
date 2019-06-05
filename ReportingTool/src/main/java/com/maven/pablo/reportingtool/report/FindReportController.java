package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.report.dto.ReportDto;
import com.maven.pablo.reportingtool.report.dto.ReportFindForm;
import com.maven.pablo.reportingtool.report.dto.Statistics;
import com.maven.pablo.reportingtool.report.entity.Report;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/report/find")
public class FindReportController {

    private EmployeeService employeeService;
    private ReportService reportService;
    private ProjectService projectService;

    @Qualifier("myProjectMapper")
    private MyMapper<Project, ProjectDto> projectMapper;
    @Qualifier("myReportMapper")
    private MyMapper<Report, ReportDto> reportMapper;
    @Qualifier("myEmployeeMapper")
    private MyMapper<Employee,EmployeeDto> employeeMapper;

    public FindReportController(EmployeeService employeeService, ReportService reportService, ProjectService projectService, MyMapper<Project,
            ProjectDto> projectMapper, MyMapper<Report, ReportDto> reportMapper, MyMapper<Employee, EmployeeDto> employeeMapper) {
        this.employeeService = employeeService;
        this.reportService = reportService;
        this.projectService = projectService;
        this.projectMapper = projectMapper;
        this.reportMapper = reportMapper;
        this.employeeMapper = employeeMapper;
    }

    @ModelAttribute("allReports")
    private List<ReportDto> allReports(){
        return reportMapper.convertToDto(reportService.findAll());
    }

    @ModelAttribute("employeeList")
    private List<EmployeeDto> employeeList(){
        return employeeMapper.convertToDto(employeeService.findAll());
    }

    @ModelAttribute("departmentList")
    private List<String> departmentList(){
        return reportService.departmentList();
    }

    @ModelAttribute("projectList")
    private List<ProjectDto> projectList(){
        return projectMapper.convertToDto(projectService.findAll());
    }

    @ModelAttribute("reportFindForm")
    private ReportFindForm reportFindForm(){
        return new ReportFindForm();
    }

    @GetMapping("/")
    public ModelAndView myReports(ModelAndView modelAndView, Principal principal){
        modelAndView.setViewName("report/all");
        modelAndView.addObject("summary", Statistics.of(allReports()));
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView findReport(@ModelAttribute ReportFindForm reportFindForm,
                                   ModelAndView modelAndView){
        List<ReportDto> reportList = reportMapper.convertToDto(reportService.findByForm(reportFindForm));
        modelAndView.addObject("allReports", reportList);
        modelAndView.addObject("summary", Statistics.of(reportList));
        modelAndView.setViewName("report/all");
        return modelAndView;
    }

}
