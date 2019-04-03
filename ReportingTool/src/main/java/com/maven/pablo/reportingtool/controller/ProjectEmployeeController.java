package com.maven.pablo.reportingtool.controller;

import com.maven.pablo.reportingtool.service.interfaces.IEmployeesInProjectService;
import com.maven.pablo.reportingtool.service.interfaces.IProjectsOfEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjectEmployeeController {

    @Autowired
    private IEmployeesInProjectService employeesInProjectService;
    @Autowired
    private IProjectsOfEmployeeService projectsOfEmployeeService;

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }

    @GetMapping("/connect/{userId}/{projectId}")
    public String connectUserToProject(@PathVariable String userId,
                                       @PathVariable String projectId)
    {
        employeesInProjectService.addEmployeeToProjectById(projectId,userId);
        projectsOfEmployeeService.addProjectToEmployee(projectId,userId);

        return "index";
    }
}