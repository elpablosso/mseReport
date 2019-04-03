package com.maven.pablo.reportingtool.ControllerMVC;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import com.maven.pablo.reportingtool.Service.Response.EmployeeDto;
import com.maven.pablo.reportingtool.Service.Response.ProjectDto;
import com.maven.pablo.reportingtool.Service.Response.ProjectMapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    IProjectService projectService;
    @Autowired
    ProjectMapper projectMapper;

    @ModelAttribute(name="projectList")
    List<ProjectDto> projectDtoList(){
        return projectMapper.listOfProjectsToDto((List<Project>) projectService.getCollectionOfAllProjects());
    }



    @GetMapping("/all")
    public ModelAndView home(ModelAndView modelAndView){

        modelAndView.setViewName("project");
        modelAndView.addObject("newProjectDto",new ProjectDto());
        modelAndView.addObject("newEmployeeDto",new EmployeeDto());

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProjectSumbit(@ModelAttribute(name = "newProjectDto") ProjectDto projectDto,
                                          ModelAndView modelAndView){

        projectService.saveProjectInRepository(projectMapper.newProjectFromDto(projectDto));
        modelAndView.setViewName("project");
        modelAndView.addObject("newProjectDto",new ProjectDto());
        modelAndView.addObject("projectList",projectDtoList());

        return modelAndView;
    }



    @GetMapping(value = "/delete")
    public ModelAndView deleteProject(@RequestParam("projectNumber") String projectNumber,
                                      ModelAndView modelAndView){

        projectService.removeProjectByNumber(projectNumber);

        modelAndView.setViewName("project");
        modelAndView.addObject("newProjectDto",new ProjectDto());
        modelAndView.addObject("projectList",projectDtoList());

        return modelAndView;
    }




}
