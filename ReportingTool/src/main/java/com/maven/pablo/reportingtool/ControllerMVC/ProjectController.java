package com.maven.pablo.reportingtool.ControllerMVC;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Service.Implementation.ProjectEmployeeService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectEmployeeService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import com.maven.pablo.reportingtool.Service.Response.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    IProjectService projectService;
    @Autowired
    IProjectEmployeeService projectEmployeeService;


    @ModelAttribute("allProjectsList")
    public List<ProjectInfo> allProjects(){
        return projectService.convertListOfProjectsIntoResponse(projectService.getListOfAllProjects());
    }


    @GetMapping(value = "add")
    public String addProjectForm(Model model) {
        model.addAttribute("projectInfo", new ProjectInfo());
        return "index";
    }

    @PostMapping(value = "add")
    public String saveProject(
            final ProjectInfo projectInfo, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        projectService.saveProjectInRepository(projectService.createProjectFromResponse(projectInfo));
        model.clear();
        return "redirect:/add";
    }


@GetMapping("")
    public ModelAndView testPage(){
    projectEmployeeService.connectUserToProject("MSE1","APK01");
    return new ModelAndView("index","projects",projectService
            .convertListOfProjectsIntoResponse(projectService.listOfProjectsWithNameContaining("NAME1")));
}

}
