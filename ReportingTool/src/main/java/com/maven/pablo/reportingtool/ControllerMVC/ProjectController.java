package com.maven.pablo.reportingtool.ControllerMVC;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    @Autowired
    IProjectService projectService;

@GetMapping("")
    public ModelAndView testPage(){
    return new ModelAndView("index","projects",projectService
            .convertListOfProjectsIntoResponse(projectService.listOfProjectsWithNameContaining("TEST")));
}


}
