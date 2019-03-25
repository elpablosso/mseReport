package com.pablo.application.controller.project;
import com.pablo.application.entity.project.Project;
import com.pablo.application.entity.project.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

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
        ModelAndView modelAndView = new ModelAndView("project/add");
        modelAndView.addObject("project", new Project());
        return modelAndView;
    }

    @RequestMapping(value = "projects/new", method = RequestMethod.POST)
    public ModelAndView submit(@Valid Project form,
                         BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            logger.info("Validation errors while submitting form.");
            modelAndView.setViewName("project/add");
            modelAndView.addObject("project", new Project());
            return modelAndView;
        }

        projectService.saveProject(form);
        modelAndView.setViewName("project/submit");

        logger.info("Form submitted successfully.");
        return modelAndView;
    }
}

