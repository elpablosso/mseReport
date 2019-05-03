package com.maven.pablo.reportingtool.project;
import com.maven.pablo.reportingtool.employee.EmployeeDto;
import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.mapper.EmployeeMapper;
import com.maven.pablo.reportingtool.project.dto.ProjectDto;
import com.maven.pablo.reportingtool.project.dto.ProjectForm;
import com.maven.pablo.reportingtool.project.entity.Project;
import com.maven.pablo.reportingtool.project.mapper.ProjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/projects")
public class ProjectController {

    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    private ProjectService service;
    private ProjectMapper mapper;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public ProjectController(EmployeeService employeeService, EmployeeMapper employeeMapper, ProjectService service, ProjectMapper mapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.service = service;
        this.mapper = mapper;
    }

    @ModelAttribute(name="projectList")
    List<ProjectDto> projectDtoList(){
        return mapper.convertToDto(service.getAllProjects());
    }
    @ModelAttribute
    List<EmployeeDto> leaderList(){
        return employeeMapper.convertToDto(employeeService.findLeaders());
    }

    @GetMapping("/all")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.addObject("projectList",projectDtoList());
        modelAndView.setViewName("project/all");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addProject(ModelAndView modelAndView){
        modelAndView.setViewName("project/add");
        modelAndView.addObject("projectForm", new ProjectForm());
        modelAndView.addObject("leaderList", leaderList());
        return modelAndView;
    }

    @GetMapping("/find")
    public ModelAndView findProject(ModelAndView modelAndView){
        modelAndView.setViewName("project/find");
        modelAndView.addObject("projectForm", new ProjectForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProjectSumbit(@Valid ProjectForm projectForm,
                                          BindingResult bindingResult,
                                          ModelAndView modelAndView){

        modelAndView.setViewName("project/add");
        modelAndView.addObject("leaderList", leaderList());
        if(bindingResult.hasErrors())
            return modelAndView;

        if(service.findProjectByProjectNumber(projectForm.getNumber())==null)
        service.saveProjectInRepository(mapper.newProjectFromForm(projectForm));

        modelAndView.addObject("projectForm",new ProjectForm());
        modelAndView.addObject("projectList",projectDtoList());
        return modelAndView;
    }

    @PostMapping("/find")
    public ModelAndView findProjectSumbit(@ModelAttribute ProjectForm projectForm,
                                          ModelAndView modelAndView){
        List<Project> projects = service.findProjectByForm(projectForm);
        List<ProjectDto> projectDtos = mapper.convertToDto(projects);
        modelAndView.setViewName("project/find");
        modelAndView.addObject("projectForm", new ProjectForm());
        modelAndView.addObject("projectList", projectDtos);
        return modelAndView;
    }

    @GetMapping("/details")
    public ModelAndView projectDetails(@RequestParam("projectNumber") String projectNumber,
                                       ModelAndView modelAndView){
        modelAndView.addObject("project",
                mapper.convertToDto(service.findProjectByProjectNumber(projectNumber)));
        modelAndView.setViewName("project/details");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView projectEdit(@RequestParam("projectNumber") String projectNumber,
                                       ModelAndView modelAndView){
        modelAndView.addObject("project",
                mapper.convertToDto(service.findProjectByProjectNumber(projectNumber)));
        modelAndView.setViewName("project/edit");
        return modelAndView;
    }

    @PostMapping("/change")
    public ModelAndView projectEditSubmit(@ModelAttribute("project") ProjectDto projectDto,
                                          ModelAndView modelAndView){

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

        service.removeProjectByNumber(projectNumber);
        modelAndView.setViewName("project/all");
        modelAndView.addObject("projectList",projectDtoList());
        return modelAndView;
    }


}
