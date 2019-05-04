package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.mapper.EmployeeMapper;
import com.maven.pablo.reportingtool.employee.implementation.MyEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private MyEmployeeService service;
    private EmployeeMapper mapper;

    @Autowired
    public EmployeeController(MyEmployeeService service, EmployeeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @ModelAttribute(name="employeeList")
    List<EmployeeDto> employeeDtoList(){
        return mapper.convertToDto(service.findAll());
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
