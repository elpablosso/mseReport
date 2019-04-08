package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.mapper.ProjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

        modelAndView.setViewName("project");
        modelAndView.addObject("newProjectDto", mapper.emptyDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProjectSumbit(@ModelAttribute("newProjectDto") ProjectDto projectDto,
                                          ModelAndView modelAndView){

        logger.info(projectDto.getNumber());
        logger.info(projectDto.getTitle());
        Project project = mapper.newProjectFromDto(projectDto);
        service.saveProjectInRepository(project);
        modelAndView.setViewName("project");
        modelAndView.addObject("newProjectDto",mapper.emptyDto());
        modelAndView.addObject("projectList",projectDtoList());

        return modelAndView;
    }



    @GetMapping(value = "/delete")
    public ModelAndView deleteProject(@RequestParam("projectNumber") String projectNumber,
                                      ModelAndView modelAndView){

        service.removeProjectByNumber(projectNumber);

        modelAndView.setViewName("project");
        modelAndView.addObject("newProjectDto",new ProjectDto());
        modelAndView.addObject("projectList",projectDtoList());

        return modelAndView;
    }




}
