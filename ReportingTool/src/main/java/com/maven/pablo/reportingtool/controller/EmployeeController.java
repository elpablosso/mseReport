package com.maven.pablo.reportingtool.controller;
import com.maven.pablo.reportingtool.entity.Employee;
import com.maven.pablo.reportingtool.service.implementation.EmployeeService;
import com.maven.pablo.reportingtool.service.responses.EmployeeDto;
import com.maven.pablo.reportingtool.service.responses.EmployeeMapper.EmployeeMapper;
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

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;


    @ModelAttribute(name="employeeList")
    List<EmployeeDto> employeeDtoList(){
        return employeeMapper.listOfEmployeesToDto((List<Employee>) employeeService.collectionOfAllEmployees());
    }

    @GetMapping("/all")
    public ModelAndView home(ModelAndView modelAndView){

        modelAndView.setViewName("employee");
        modelAndView.addObject("employeeList", employeeDtoList());
        modelAndView.addObject("newEmployeeDto",new EmployeeDto());

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveEmployeeSumbit(@ModelAttribute(name = "newEmployeeDto") EmployeeDto employeeDto,
                                           ModelAndView modelAndView){
        employeeService.saveEmployeeInRepository(employeeMapper.newEmployeeFromDto(employeeDto));

        modelAndView.setViewName("employee");
        modelAndView.addObject("newEmployeeDto",new EmployeeDto());
        modelAndView.addObject("employeeList",employeeDtoList());

        return modelAndView;
    }

}
