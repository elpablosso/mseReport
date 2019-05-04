package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.report.mapper.ReportMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("reports")
public class ReportController {

    CompleteReportDto completeReportDto;
    ReportService service;
    ProjectService projectService;
    ReportMapper mapper;

    @Autowired
    public ReportController(CompleteReportDto completeReportDto, ReportService service,
                            ProjectService projectService, ReportMapper mapper) {
        this.completeReportDto = completeReportDto;
        this.service = service;
        this.projectService = projectService;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public ModelAndView allReports(ModelAndView modelAndView){

        modelAndView.addObject("departmentList", service.departmentList());
        modelAndView.addObject("newReportDto", mapper.emptyReportDto());
        modelAndView.addObject("projectList", projectService.getAllProjects());
        modelAndView.addObject("reportList", completeReportDto.getReports());
        modelAndView.setViewName("reports");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveReportPart(@ModelAttribute("newReportDto")ReportDto reportDto,
                                       ModelAndView modelAndView, BindingResult bindingResult){
        return modelAndView;
    }



}
