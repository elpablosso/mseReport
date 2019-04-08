package com.maven.pablo.reportingtool.report;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.report.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("reports")
public class ReportController {

    @Autowired
    ReportService service;
    @Autowired
    ProjectService projectService;
    @Autowired
    ReportMapper mapper;


    @RequestMapping("all")
    public ModelAndView allReports(ModelAndView modelAndView){
        modelAndView.addObject("newReportDto",mapper.emptyReportDto());
        modelAndView.addObject("projectList",projectService.getAllProjects());
        modelAndView.addObject("reportList",mapper.convertToDto(service.findAllReports()));
        modelAndView.setViewName("reports");
        return modelAndView;
    }



}
