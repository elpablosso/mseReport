package com.pablo.application.controller;
import com.pablo.application.entity.project.Project;
import com.pablo.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(path="/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value="/list")
    public String home(Model model){
        model.addAttribute("projects", projectService.findAll());
        return "projectlist";
    }

    @GetMapping(path="/all")
    @ResponseBody
    public List<Project> projects(){
        return projectService.findAll();
    }

    @GetMapping(path="/{projectNumber}")
    @ResponseBody
    public Project findProject(@PathVariable String projectNumber){
        return projectService.findByNumber(projectNumber);
    }

    @RequestMapping(path="/update", method = RequestMethod.POST)
    @ResponseBody
    public Project updateProject(
            @RequestBody Project project){
        Project findProject = projectService.findByNumber(project.getNumber());
        return projectService.saveProject(project);
    }

    @GetMapping(path="/changebudget")
    @ResponseBody
    public Project changeProjectBudget(@RequestParam String projectNumber,
                                       @RequestParam int budget){
        Project project = projectService.findByNumber(projectNumber);
        project.setBudget(budget);
        return projectService.saveProject(project);
    }

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewProject (@RequestParam String projectNumber) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return projectService.createNewProject(projectNumber);
    }
}
