package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.enums.Role;
import com.maven.pablo.reportingtool.exceptions.EmployeeNotFoundException;
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

    @Qualifier("myEmployeeMapper")
    private MyMapper<Employee,EmployeeDto> employeeMapper;
    @Qualifier("myProjectMapper")
    private MyMapper<Project,ProjectDto> projectMapper;

    @Autowired
    public ProjectController(EmployeeService employeeService, ProjectService projectService,
                              MyMapper<Employee,EmployeeDto> employeeMapper, MyMapper<Project, ProjectDto> projectMapper1) {
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.employeeMapper = employeeMapper;
        this.projectMapper = projectMapper1;
    }
    @ModelAttribute("projectDto")
    private ProjectDto newProjectDto(){
        return new ProjectDto(); }

    @ModelAttribute("leaderList")
    private List<EmployeeDto> leaderList(){
        return findByRole(Role.LEADER); }

    @ModelAttribute("designerList")
    private List<EmployeeDto> designerList(){
        return findByRole(Role.DESIGNER); }

    private List<ProjectDto> allProjects(){
        return projectMapper.convertToDto(projectService.findAll());
    }
    private List<EmployeeDto> findByRole(Role role){
        return employeeMapper.convertToDto(employeeService.findByRole(role));
    }
    private List<ProjectDto> filteredProjects(ProjectDto projectDto){
        List<Project> projects = projectService.findByForm(projectDto);
        return projectMapper.convertToDto(projects);
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.addObject("projectList",allProjects());
        modelAndView.setViewName("project/all");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addProjectSumbit(@Valid ProjectDto projectDto,
                                          BindingResult bindingResult,
                                          ModelAndView modelAndView) throws EmployeeNotFoundException {

        modelAndView.setViewName("project/all");

        if(bindingResult.hasErrors()) {
            modelAndView.addObject("projectList",allProjects());
            return modelAndView; }

            if(!projectService.projectOfNumberExist(projectDto.getNumber())) {
                projectDto.setLeader(employeeService.findById(projectDto.getLeaderId()));
                projectDto.setDesigner(employeeService.findById(projectDto.getDesignerId()));
                projectService.save(projectMapper.newInstanceFromDto(projectDto));
            }

        modelAndView.addObject("projectList",allProjects());
        modelAndView.addObject("projectDto");
        return modelAndView;
    }

    @PostMapping("/find")
    public ModelAndView findProjectSumbit(@ModelAttribute ProjectDto projectDto,
                                          ModelAndView modelAndView){
        modelAndView.setViewName("project/all");
        modelAndView.addObject("projectList", filteredProjects(projectDto));
        return modelAndView;
    }


    @GetMapping("/delete")
    public ModelAndView deleteProject(@RequestParam("projectNumber") String projectNumber,
                                      ModelAndView modelAndView) throws ProjectNotFoundException {

        Project project = projectService.findByNumber(projectNumber);
        projectService.delete(project);
        modelAndView.setViewName("project/all");
        modelAndView.addObject("projectList",allProjects());
        return modelAndView;
    }


}
