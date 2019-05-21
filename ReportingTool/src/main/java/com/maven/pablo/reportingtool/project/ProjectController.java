package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.mapper.MyMapper;
import com.maven.pablo.reportingtool.project.dto.ProjectDetailsDto;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.entity.ProjectDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/projects")
public class ProjectController {

    private EmployeeService employeeService;
    private ProjectService projectService;
    private ProjectDetailsService projectDetailsService;


    @Qualifier("myProjectDetailsMapper")
    private MyMapper<ProjectDetails, ProjectDetailsDto> projectDetailsMapper;
    @Qualifier("myEmployeeMapper")
    private MyMapper<Employee,EmployeeDto> employeeMapper;
    @Qualifier("myProjectMapper")
    private MyMapper<Project,ProjectDto> projectMapper;

    @Autowired
    public ProjectController(EmployeeService employeeService, ProjectService projectService, ProjectDetailsService projectDetailsService, MyMapper<ProjectDetails, ProjectDetailsDto> projectDetailsMapper, MyMapper<Employee,
            EmployeeDto> employeeMapper, MyMapper<Project, ProjectDto> projectMapper1) {
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.projectDetailsService = projectDetailsService;
        this.projectDetailsMapper = projectDetailsMapper;
        this.employeeMapper = employeeMapper;
        this.projectMapper = projectMapper1;
    }

    @ModelAttribute
    private List<ProjectDto> projectDtoList(){
        return projectMapper.convertToDto(projectService.findAll());
    }
    @ModelAttribute
    private List<EmployeeDto> leaderList(){
        return employeeMapper.convertToDto(employeeService.findLeaders());
    }

    @GetMapping("/all")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.addObject("projectList",projectDtoList());
        modelAndView.setViewName("project/all");
        return modelAndView;
    }

    @GetMapping("/my")
    public ModelAndView myProjects(ModelAndView modelAndView, Principal principal){

        List<ProjectDetails> myProjectDetails = projectDetailsService.findByEmployeeId(principal.getName());
        List<ProjectDetailsDto> projectDetailsList = projectDetailsMapper.convertToDto(myProjectDetails);

        modelAndView.addObject("projectDetailsList",projectDetailsList);
        modelAndView.setViewName("project/my");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addProject(ModelAndView modelAndView){
        modelAndView.setViewName("project/add");
        modelAndView.addObject("projectList",projectDtoList());
        modelAndView.addObject("projectDto", new ProjectDto());
        modelAndView.addObject("leaderList", leaderList());
        return modelAndView;
    }

    @GetMapping("/find")
    public ModelAndView findProject(ModelAndView modelAndView){
        modelAndView.setViewName("project/find");
        modelAndView.addObject("projectList",projectDtoList());
        modelAndView.addObject("projectDto", new ProjectDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProjectSumbit(@Valid ProjectDto projectDto,
                                          BindingResult bindingResult,
                                          ModelAndView modelAndView){

        modelAndView.setViewName("project/add");
        modelAndView.addObject("leaderList", leaderList());

        if(bindingResult.hasErrors()) {
            modelAndView.addObject("projectList",projectDtoList());
            return modelAndView; }

        if(projectService.findByNumber(projectDto.getNumber())==null) {
            Employee leader = employeeService.findById(projectDto.getLeaderId());
            projectDto.setLeader(leader);
            projectService.saveProject(projectMapper.newInstanceFromDto(projectDto));
        }

        modelAndView.addObject("projectDto",new ProjectDto());
        modelAndView.addObject("projectList",projectDtoList());
        return modelAndView;
    }

    @PostMapping("/find")
    public ModelAndView findProjectSumbit(@ModelAttribute ProjectDto projectDto,
                                          ModelAndView modelAndView){

        List<Project> projects = projectService.findByForm(projectDto);
        List<ProjectDto> projectDtos = projectMapper.convertToDto(projects);
        modelAndView.setViewName("project/find");
        modelAndView.addObject("projectDto", new ProjectDto());
        modelAndView.addObject("projectList", projectDtos);
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteConfirmation(@RequestParam("projectNumber") String projectNumber,
                                      ModelAndView modelAndView){

        modelAndView.setViewName("project/delete");
        modelAndView.addObject("projectNumber", projectNumber);
        return modelAndView;
    }

    @GetMapping("/deleteConfirmed")
    public ModelAndView deleteProject(@RequestParam("projectNumber") String projectNumber,
                                      ModelAndView modelAndView){

        projectService.deleteProjectByNumber(projectNumber);
        modelAndView.setViewName("project/all");
        modelAndView.addObject("projectList",projectDtoList());
        return modelAndView;
    }


}
