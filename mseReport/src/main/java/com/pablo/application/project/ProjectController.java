package com.pablo.application.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(path="/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping(path="/all")
    @ResponseBody
    public List<Project> projects(){
        return projectService.findAll();
    }

    @GetMapping(path="/{projectNumber}")
    @ResponseBody
    public Project findProject(@PathVariable String projectNumber){
        return projectService.findByProjectNumber(projectNumber);
    }

    @RequestMapping(path="/update", method = RequestMethod.POST)
    @ResponseBody
    public Project updateProject(
            @RequestBody Project project){
        Project findProject = projectService.findByProjectNumber(project.getProjectNumber());
        return projectService.saveProject(project);
    }

    @GetMapping(path="/changebudget")
    @ResponseBody
    public Project changeProjectBudget(@RequestParam String projectNumber,
                                       @RequestParam int budget){
        Project project = projectService.findByProjectNumber(projectNumber);
        project.setProjectBudget(budget);
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
