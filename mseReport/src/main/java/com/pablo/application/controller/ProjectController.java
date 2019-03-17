package com.pablo.application.controller;

import com.pablo.application.entity.project.Project;
import com.pablo.application.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    // MAPPING CREATION OF NEW PROJECT
    @GetMapping(value="projects/add")
    public ModelAndView addProjectForm(){
    return new ModelAndView("project/add","project", new Project());
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
