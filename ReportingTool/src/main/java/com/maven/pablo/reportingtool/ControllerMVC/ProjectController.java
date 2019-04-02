package com.maven.pablo.reportingtool.ControllerMVC;
import com.maven.pablo.reportingtool.Entity.Employee;
import com.maven.pablo.reportingtool.Entity.Project;
import com.maven.pablo.reportingtool.Service.Implementation.EmployeeService;
import com.maven.pablo.reportingtool.Service.Interface.IProjectService;
import com.maven.pablo.reportingtool.Service.Response.EmployeeDto;
import com.maven.pablo.reportingtool.Service.Response.EmployeeMapper.EmployeeMapper;
import com.maven.pablo.reportingtool.Service.Response.ProjectDto;
import com.maven.pablo.reportingtool.Service.Response.ProjectMapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    IProjectService projectService;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;

    @ModelAttribute(name="projectList")
    List<ProjectDto> projectDtoList(){
        return projectMapper.listOfProjectsToDto((List<Project>) projectService.getCollectionOfAllProjects());
    }
    @ModelAttribute(name="employeeList")
    List<EmployeeDto> employeeDtoList(){
        return employeeMapper.listOfEmployeesToDto((List<Employee>) employeeService.collectionOfAllEmployees());
    }

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newProjectDto",new ProjectDto());
        modelAndView.addObject("newEmployeeDto",new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/saveProject")
    public ModelAndView saveProjectSumbit(@ModelAttribute(name = "newProjectDto") ProjectDto projectDto){
        projectService.saveProjectInRepository(projectMapper.newProjectFromDto(projectDto));
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newProjectDto",new ProjectDto());
        modelAndView.addObject("newEmployeeDto",new EmployeeDto());
        modelAndView.addObject("projectList",projectDtoList());
        modelAndView.addObject("employeeList",employeeDtoList());
        return modelAndView;
    }

    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployeeSumbit(@ModelAttribute(name = "newEmployeeDto") EmployeeDto employeeDto){
        employeeService.saveEmployeeInRepository(employeeMapper.newEmployeeFromDto(employeeDto));
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newEmployeeDto",new EmployeeDto());
        modelAndView.addObject("newProjectDto",new ProjectDto());
        modelAndView.addObject("employeeList",employeeDtoList());
        modelAndView.addObject("projectList",projectDtoList());
        return modelAndView;
    }

    @GetMapping(value = "/deleteProject")
    public ModelAndView deleteProject(@RequestParam("projectNumber") String projectNumber){
        projectService.removeProjectByNumber(projectNumber);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newProjectDto",new ProjectDto());
        modelAndView.addObject("projectList",projectDtoList());
        modelAndView.addObject("newEmployeeDto",new EmployeeDto());
        modelAndView.addObject("employeeList",employeeDtoList());
        return modelAndView;
    }




}
