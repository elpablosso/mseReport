package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.mapper.EmployeeMapper;
import com.maven.pablo.reportingtool.employee.implementation.MyEmployeeService;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.report.ReportService;
import com.maven.pablo.reportingtool.report.entity.Report;
import com.maven.pablo.reportingtool.report.entity.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private MyEmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    private ProjectService projectService;
    private ReportRepository reportService;

    @Autowired
    public EmployeeController(MyEmployeeService employeeService, EmployeeMapper employeeMapper, ProjectService projectService, ReportRepository reportService) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.projectService = projectService;
        this.reportService = reportService;
    }

    @ModelAttribute(name="employeeList")
    List<EmployeeDto> employeeDtoList(){
        return employeeMapper.convertToDto(employeeService.findAll());
    }


    @GetMapping("/all")
    public ModelAndView home(ModelAndView modelAndView,
                             Principal principal){

        modelAndView.setViewName("employee");
        modelAndView.addObject("username", principal.getName());
        modelAndView.addObject("employeeList", employeeDtoList());
        return modelAndView;
    }


}
