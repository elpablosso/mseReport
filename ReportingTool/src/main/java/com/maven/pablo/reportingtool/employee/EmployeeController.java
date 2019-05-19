package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.implementation.MyEmployeeService;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import com.maven.pablo.reportingtool.project.ProjectService;
import com.maven.pablo.reportingtool.report.entity.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private ProjectService projectService;
    private ReportRepository reportService;

    @Qualifier("myEmployeeMapper")
    private MyMapper<Employee,EmployeeDto> employeeMapper;

    @Autowired
    public EmployeeController(MyEmployeeService employeeService, ProjectService projectService,
                              ReportRepository reportService, MyMapper<Employee, EmployeeDto> employeeMapper) {
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.reportService = reportService;
        this.employeeMapper = employeeMapper;
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
