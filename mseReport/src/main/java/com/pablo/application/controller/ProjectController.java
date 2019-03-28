package com.pablo.application.controller;
import com.pablo.application.entity.project.Project;
import com.pablo.application.repository.ProjectRepository;
import com.pablo.application.service.ProjectService;
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
@RequestMapping("project")
public class ProjectController {


    @Autowired
    ProjectRepository projectRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @GetMapping("all")
    @ResponseBody
    public List<Project> allProjects(){
        return (List<Project>) projectRepository.findAll();
    }
}

