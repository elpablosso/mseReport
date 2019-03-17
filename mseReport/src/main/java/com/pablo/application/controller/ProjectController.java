package com.pablo.application.controller;
import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.project.ProjectNameResolver;
import com.pablo.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    // MAPPING A PROJECT LIST ATTRIBUTE TO THE VIEW
    @GetMapping(value="projects/list")
    public String projectList(ModelMap modelMap){
        modelMap.addAttribute("projects", projectService.findAll());
        return "project/list";
    }

    // MAPPING A PROJECT LIST ATTRIBUTE TO THE VIEW
    @GetMapping(value="projects/sort/budget")
    public String sortedList(ModelMap modelMap){
        modelMap.addAttribute("projects", projectService.sortedByBudget());
        return "project/list";
    }

    @GetMapping(value="projects/all")
    public @ResponseBody List<Project> allProjects(){
        return projectService.findAll();
    }

    // MAPPING CREATION OF NEW PROJECT
    @GetMapping(value="projects/add")
    public ModelAndView addProjectForm(){
    return new ModelAndView("project/add","project", new Project());
    }


    @GetMapping(value="projects/find")
    public ModelAndView findProjectForm() { return new ModelAndView("project/find","project", new Project());}


    @RequestMapping(value = "projects/found", method = RequestMethod.POST)
    public String findProject(@Valid @ModelAttribute ("project")Project found, ModelMap model) {

            Project foundProject = projectService.findByNumber(found.getNumber());

                model.addAttribute("number", foundProject.getNumber());
                model.addAttribute("name", foundProject.getName());
                model.addAttribute("budget", foundProject.getBudget());

            return "project/submit";
        }

    @RequestMapping(value = "projects/new", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("project")Project project,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "index";
        }
        model.addAttribute("number", project.getNumber());
        model.addAttribute("name", project.getName());
        model.addAttribute("budget", project.getBudget());

        projectService.saveProject(project);

        return "project/submit";
    }
}

