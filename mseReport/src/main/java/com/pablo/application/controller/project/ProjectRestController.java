package com.pablo.application.controller.project;

import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "rest/projects")
public class ProjectRestController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value="add")
    public String addNewProject(@RequestParam String projectNumber){
        return projectService.createAndSaveByProjectNumber(projectNumber);
    }

    @RequestMapping(value="{number}")
    public Project projectByNumber(@PathVariable(value = "number") String projectNumber){
        return projectService.findByNumber(projectNumber);
    }


    @RequestMapping(value="all")
    public List<Project> allProjects(){
        return projectService.findAll();
    }

}
