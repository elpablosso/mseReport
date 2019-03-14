package com.pablo.application.controller;
import com.pablo.application.service.Departments;
import com.pablo.application.entity.department.ProjectDepartment;
import com.pablo.application.service.ProjectDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ComponentScan(basePackages = {"java.application.project", "java.application.ProjectDepartment"})
@Controller
@RequestMapping(path="/projects/hours")
public class ProjectDepartmentController {

    @Autowired
    ProjectDepartmentService projectDepartmentService;

    @GetMapping(path="/{projectNumber}")
    @ResponseBody
    public ProjectDepartment findProject(@PathVariable String projectNumber){
        return projectDepartmentService.findByProjectNumber(projectNumber);
    }

    @GetMapping(path="increase/{projectNumber}")
    @ResponseBody
    public String increaseDeparment(@PathVariable String projectNumber,
                                               @RequestParam String dep,
                                               @RequestParam double value){
        Departments department = Enum.valueOf(Departments.class, dep);
        projectDepartmentService.increaseHours(projectNumber, department, value);
        return "Increased.";
    }
}
