package com.pablo.application.controller;

import com.pablo.application.entity.department.ProjectDepartment;
import com.pablo.application.service.ProjectDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value="/hours")
public class DepartmentController {

    @Autowired
    ProjectDepartmentService projectDepartmentService;

    @GetMapping(value = "/add")
    @ResponseBody
    public String addHours(@RequestParam String pNumber,
                           @RequestParam String userId){
        projectDepartmentService.createNewProjectDepartment(pNumber,userId);

        return "Saved";
    }

    @GetMapping(value="/find")
            public @ResponseBody List<ProjectDepartment> allUserHours(
                    @RequestParam String userId) {

        return projectDepartmentService.allHoursByUserId(userId);
    }

    @GetMapping(value="/all")
    public @ResponseBody List<ProjectDepartment> allHours(){
        return projectDepartmentService.findAll();
    }
}
