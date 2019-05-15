package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.project.ProjectDetailsService;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.project.mapper.ProjectMapper;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.implementation.MyCompleteReport;
import com.maven.pablo.reportingtool.report.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/reports")
public class ReportController {

    private MyCompleteReport myCompleteReport;
    private EmployeeService employeeService;
    private ReportService reportService;
    private ProjectService projectService;
    private ProjectMapper projectMapper;
    private ReportMapper reportMapper;
    private ProjectDetailsService projectDetailsService;

    @Autowired
    public ReportController(MyCompleteReport myCompleteReport, EmployeeService employeeService, ReportService service,
                            ProjectService projectService, ProjectMapper projectMapper, ReportMapper mapper, ProjectDetailsService projectDetailsService) {
        this.myCompleteReport = myCompleteReport;
        this.employeeService = employeeService;
        this.reportService = service;
        this.projectService = projectService;
        this.projectMapper = projectMapper;
        this.reportMapper = mapper;
        this.projectDetailsService = projectDetailsService;
    }

    void initialize(ModelAndView modelAndView){
        modelAndView.addObject("departmentList", reportService.departmentList());
        modelAndView.addObject("projectList", projectMapper.convertToDto(projectService.findAll()));
        modelAndView.addObject("reportList", myCompleteReport.getReports());
        modelAndView.setViewName("reports");
    }

    @GetMapping("/all")
    public ModelAndView allReports(ModelAndView modelAndView){
        modelAndView.addObject("reportDto", new ReportDto());
        initialize(modelAndView);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveReportPart(@Valid @ModelAttribute("reportDto") ReportDto reportDto, BindingResult bindingResult,
                                       Principal principal, ModelAndView modelAndView ){

        initialize(modelAndView);

        if(bindingResult.hasErrors()){
            return modelAndView; }

        reportDto.setEmployeeId(principal.getName());
        myCompleteReport.addReport(reportDto);
        modelAndView.addObject("reportList", myCompleteReport.getReports());
        return modelAndView;
    }

    @GetMapping("/send")
    public ModelAndView sendReport(ModelAndView modelAndView, Principal principal){

        Employee employee = employeeService.findById(principal.getName());
        List<Report> reports = reportMapper.convertFromDto(myCompleteReport.getReports());

        reportService.save(reports);
        employeeService.addUnreadReport(reports);
        projectDetailsService.addHoursFromReport(reports);


        myCompleteReport = new MyCompleteReport();
        initialize(modelAndView);
        modelAndView.setViewName("reports");

        return modelAndView;
    }


}
