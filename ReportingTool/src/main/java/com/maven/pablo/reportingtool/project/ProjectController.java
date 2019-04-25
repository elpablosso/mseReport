package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.mapper.ProjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService service;
    private ProjectMapper mapper;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public ProjectController(ProjectService service, ProjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @ModelAttribute(name="projectList")
    List<ProjectDto> projectDtoList(){
        return mapper.convertToDto(service.getAllProjects());
    }

    @GetMapping("/all")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.addObject("projectList",projectDtoList());
        modelAndView.setViewName("project/all");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addProject(ModelAndView modelAndView){
        modelAndView.setViewName("project/add");
        modelAndView.addObject("projectForm", new ProjectForm());
        return modelAndView;
    }

    @GetMapping("/find")
    public ModelAndView findProject(ModelAndView modelAndView){
        modelAndView.setViewName("project/find");
        modelAndView.addObject("projectForm", new ProjectForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProjectSumbit(@Valid ProjectForm projectForm,
                                          BindingResult bindingResult,
                                          ModelAndView modelAndView){
        modelAndView.setViewName("project/add");
        if(bindingResult.hasErrors())
            return modelAndView;

        service.saveProjectInRepository(mapper.newProjectFromForm(projectForm));
        modelAndView.addObject("projectForm",new ProjectForm());
        modelAndView.addObject("projectList",projectDtoList());
        return modelAndView;
    }

    @PostMapping("/find")
    public ModelAndView findProjectSumbit(@ModelAttribute ProjectForm projectForm,
                                          ModelAndView modelAndView){
        List<Project> projects = service.findProjectByForm(projectForm);
        modelAndView.setViewName("project/find");
        modelAndView.addObject("projectForm", new ProjectForm());
        modelAndView.addObject("projectList", projects);
        return modelAndView;
    }

    @GetMapping("/details")
    public ModelAndView projectDetails(@RequestParam("projectNumber") String projectNumber,
                                       ModelAndView modelAndView){
        modelAndView.addObject("project",
                mapper.convertToDto(service.findProjectByProjectNumber(projectNumber)));
        modelAndView.setViewName("project/details");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteProject(@RequestParam("projectNumber") String projectNumber,
                                      ModelAndView modelAndView){

        service.removeProjectByNumber(projectNumber);
        modelAndView.setViewName("project/all");
        modelAndView.addObject("projectList",projectDtoList());
        return modelAndView;
    }




}
