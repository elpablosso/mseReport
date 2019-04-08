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

    private EmployeeServiceImp employeeServiceImp;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeController(EmployeeServiceImp employeeServiceImp, EmployeeMapper employeeMapper) {
        this.employeeServiceImp = employeeServiceImp;
        this.employeeMapper = employeeMapper;
    }

    @ModelAttribute(name="employeeList")
    List<EmployeeDto> employeeDtoList(){
        return employeeMapper.convertToDto((List<Employee>) employeeServiceImp.findAll());
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
        employeeServiceImp.saveInRepository(employeeMapper.newEmployeeFromDto(employeeDto));

        modelAndView.setViewName("employee");
        modelAndView.addObject("newEmployeeDto",new EmployeeDto());
        modelAndView.addObject("employeeList",employeeDtoList());

        return modelAndView;
    }

}
