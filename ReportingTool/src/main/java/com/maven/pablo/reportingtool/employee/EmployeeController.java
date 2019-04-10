package com.maven.pablo.reportingtool.employee;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.mapper.EmployeeMapper;
import com.maven.pablo.reportingtool.employee.implementation.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeServiceImp service;
    private EmployeeMapper mapper;

    @Autowired
    public EmployeeController(EmployeeServiceImp service, EmployeeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @ModelAttribute(name="employeeList")
    List<EmployeeDto> employeeDtoList(){
        return mapper.convertToDto((List<Employee>) service.findAll());
    }

    @GetMapping("/all")
    public ModelAndView home(ModelAndView modelAndView){

        modelAndView.setViewName("employee");
        modelAndView.addObject("employeeList", employeeDtoList());
        modelAndView.addObject("newEmployeeDto", mapper.emptyEmployeeDto());

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveEmployeeSumbit(@ModelAttribute(name = "newEmployeeDto") EmployeeDto employeeDto,
                                           ModelAndView modelAndView){

        service.saveInRepository(mapper.newEmployeeFromDto(employeeDto));
        modelAndView.setViewName("employee");
        modelAndView.addObject("newEmployeeDto", mapper.emptyEmployeeDto());
        modelAndView.addObject("employeeList",employeeDtoList());

        return modelAndView;
    }

}