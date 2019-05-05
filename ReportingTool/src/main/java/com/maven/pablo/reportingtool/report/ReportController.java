package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.project.mapper.ProjectMapper;
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


@Controller
@RequestMapping("/reports")
public class ReportController {

    private CompleteReportDto completeReportDto;
    private EmployeeService employeeService;
    private ReportService reportService;
    private ProjectService projectService;
    private ProjectMapper projectMapper;
    private ReportMapper reportMapper;

    @Autowired
    public ReportController(CompleteReportDto completeReportDto, EmployeeService employeeService, ReportService service,
                            ProjectService projectService, ProjectMapper projectMapper, ReportMapper mapper) {
        this.completeReportDto = completeReportDto;
        this.employeeService = employeeService;
        this.reportService = service;
        this.projectService = projectService;
        this.projectMapper = projectMapper;
        this.reportMapper = mapper;
    }

    void initialize(ModelAndView modelAndView){
        modelAndView.addObject("departmentList", reportService.departmentList());
        modelAndView.addObject("projectList", projectMapper.convertToDto(projectService.findAll()));
        modelAndView.addObject("reportList", completeReportDto.getReports());
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

        Employee employee = employeeService.findByUsername(principal.getName());
        reportDto.setEmployeeId(employee.getId());

        completeReportDto.getReports().add(reportDto);
        modelAndView.addObject("reportList", completeReportDto.getReports());

        return modelAndView;
    }



}
