package com.maven.pablo.reportingtool.ControllerMVC;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Service.Interface.IEmployeeService;
import com.maven.pablo.reportingtool.Service.Interface.IEmployeesInProjectService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectsOfEmployeeService;
import com.maven.pablo.reportingtool.Service.Response.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProjectController {

    @Autowired
    IProjectService projectService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IProjectsOfEmployeeService projectsOfEmployeeService;
    @Autowired
    IEmployeesInProjectService employeesInProjectService;

    @GetMapping("/{id}")
    public ResponseEntity<ProjectInfo> find(@PathVariable(name="id") String id){
        Project project = projectService.findProjectByProjectNumber(id);
        return new ResponseEntity<>(new ProjectInfo(project), HttpStatus.OK);
    }

    @GetMapping("/add")
    public @ResponseBody String connectUserToProject(@RequestParam String userId,
                                       @RequestParam String projectId)
    {
        employeesInProjectService.addEmployeeToProjectById(projectId,userId);
        projectsOfEmployeeService.addProjectToEmployee(projectId,userId);
        return "Done!";
    }


    @PostMapping(value = "delete_project/{projectNumber}")
    public String removeEmployee(@PathVariable("projectNumber") String projectNumber){
        projectService.removeProjectByNumber(projectNumber);
        return "index";
    }




}
