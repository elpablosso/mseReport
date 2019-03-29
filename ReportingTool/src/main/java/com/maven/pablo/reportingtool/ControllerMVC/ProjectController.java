package com.maven.pablo.reportingtool.ControllerMVC;
import com.maven.pablo.reportingtool.Service.Implementation.ProjectEmployeeService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    @Autowired
    IProjectService projectService;
    @Autowired
    ProjectEmployeeService projectEmployeeService;

@GetMapping("")
    public ModelAndView testPage(){
    projectEmployeeService.connectUserToProject("MSE1","APK01");
    return new ModelAndView("index","projects",projectService
            .convertListOfProjectsIntoResponse(projectService.listOfProjectsWithNameContaining("NAME1")));
}

}
