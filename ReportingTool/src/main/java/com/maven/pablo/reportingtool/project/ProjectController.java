package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.exceptions.ProjectNotFoundException;
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
    public ProjectController(EmployeeService employeeService, ProjectService projectService,
                             ProjectDetailsService projectDetailsService, MyMapper<ProjectDetails,
                             ProjectDetailsDto> projectDetailsMapper, MyMapper<Employee,
                             EmployeeDto> employeeMapper, MyMapper<Project, ProjectDto> projectMapper1) {
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.projectDetailsService = projectDetailsService;
        this.projectDetailsMapper = projectDetailsMapper;
        this.employeeMapper = employeeMapper;
        this.projectMapper = projectMapper1;
    }

    @ModelAttribute
    private List<ProjectDto> allProjects(){
        return projectMapper.convertToDto(projectService.findAll());
    }
    @ModelAttribute
    private List<EmployeeDto> leaderList(){
        return employeeMapper.convertToDto(employeeService.findLeaders());
    }
    @ModelAttribute
    private List<ProjectDto> filteredProjects(ProjectDto projectDto){
        List<Project> projects = projectService.findByForm(projectDto);
        return projectMapper.convertToDto(projects);
    }

    @GetMapping("/all")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.addObject("projectList",allProjects());
        modelAndView.setViewName("project/all");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addProject(ModelAndView modelAndView){
        modelAndView.setViewName("project/add");
        modelAndView.addObject("projectDto", new ProjectDto());
        modelAndView.addObject("projectList",allProjects());
        modelAndView.addObject("leaderList", leaderList());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addProjectSumbit(@Valid ProjectDto projectDto,
                                          BindingResult bindingResult,
                                          ModelAndView modelAndView) throws ProjectNotFoundException {

        modelAndView.setViewName("project/add");
        modelAndView.addObject("leaderList", leaderList());

        if(bindingResult.hasErrors()) {
            modelAndView.addObject("projectList",allProjects());
            return modelAndView; }

            if(!projectService.projectOfNumberExist(projectDto.getNumber())) {
                projectDto.setLeader(employeeService.findById(projectDto.getLeaderId()));
                projectService.saveProject(projectMapper.newInstanceFromDto(projectDto));
            }

        modelAndView.addObject("projectList",allProjects());
        return modelAndView;
    }

    @GetMapping("/find")
    public ModelAndView findProject(ModelAndView modelAndView){
        modelAndView.setViewName("project/find");
        modelAndView.addObject("projectList",allProjects());
        //modelAndView.addObject("projectDto", new ProjectDto());
        return modelAndView;
    }

    @PostMapping("/find")
    public ModelAndView findProjectSumbit(@ModelAttribute ProjectDto projectDto,
                                          ModelAndView modelAndView){
        modelAndView.setViewName("project/find");
        modelAndView.addObject("projectList", filteredProjects(projectDto));
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









    @GetMapping("/delete")
    public ModelAndView deleteConfirmation(@RequestParam("projectNumber") String projectNumber,
                                      ModelAndView modelAndView){

        modelAndView.setViewName("project/delete");
        modelAndView.addObject("projectNumber", projectNumber);
        return modelAndView;
    }

    @GetMapping("/deleteConfirmed")
    public ModelAndView deleteProject(@RequestParam("projectNumber") String projectNumber,
                                      ModelAndView modelAndView) throws ProjectNotFoundException {

        projectService.deleteProjectByNumber(projectNumber);
        modelAndView.setViewName("project/all");
        modelAndView.addObject("projectList",allProjects());
        return modelAndView;
    }


}
