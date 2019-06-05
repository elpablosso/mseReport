package com.maven.pablo.reportingtool;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.exceptions.EmployeeNotFoundException;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
public class HomeController {

    private EmployeeService employeeService;
    private MyMapper<Employee, EmployeeDto> employeeMapper;

    @Autowired
    public HomeController(EmployeeService employeeService, MyMapper<Employee, EmployeeDto> employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @ModelAttribute("loggedEmployee")
    public EmployeeDto loggedEmployee(Principal principal) throws EmployeeNotFoundException {
        return (principal==null) ?
                null :
                employeeMapper.convertToDto(employeeService.findByUsername(principal.getName()));
    }

    @GetMapping("/")
    public String index(Principal principal) {
        return (principal==null) ? "login" : "index" ;
    }

    @PostMapping(value = "/login")
    public String postLogin(Principal principal)
    {
        return (principal==null) ? "login" : "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/logout")
    public String postLogout() {
        return "redirect:/logout";
    }

    @RequestMapping("/login-error")
    public String errorLogin(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}
